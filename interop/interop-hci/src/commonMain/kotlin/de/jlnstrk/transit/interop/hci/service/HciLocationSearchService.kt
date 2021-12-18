package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.client.hci.HciConsumer
import de.jlnstrk.transit.client.hci.HciException
import de.jlnstrk.transit.client.hci.method.locmatch.HciLocMatchRequest
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.model.location.HciLocationField
import de.jlnstrk.transit.client.hci.model.location.HciLocationInput
import de.jlnstrk.transit.client.hci.request.filter.HciLocationFilter
import de.jlnstrk.transit.client.hci.request.filter.HciRequestFilterMode
import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.ProductClass
import de.jlnstrk.transit.common.response.LocationListData
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.LocationSearchResult
import de.jlnstrk.transit.common.service.LocationSearchService
import de.jlnstrk.transit.interop.hci.HciInteropService
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.conversion.asCommon

internal class HciLocationSearchService(
    provider: HciProvider,
    consumer: HciConsumer
) : HciInteropService(provider, consumer), LocationSearchService {
    override val supportsFilterTypes: Boolean get() = true
    override val supportsFilterProducts: Boolean get() = true
    override val supportsMaxResults: Boolean get() = true

    override suspend fun locationSearch(
        query: String,
        filterTypes: Set<Location.Type>?,
        filterProducts: Set<ProductClass>?,
        maxResults: Int?
    ): LocationSearchResult {
        val locationFilters = filterProducts?.let {
            listOf(
                HciLocationFilter(
                    type = HciLocationFilter.Type.PROD,
                    mode = HciRequestFilterMode.INC,
                    value = provider.setToBitmask(it).toString()
                )
            )
        }
        val hciRequest = HciLocMatchRequest(
            input = HciLocationInput(
                loc = HciLocation(
                    name = "$query?",
                    type = filterTypes?.let {
                        when (it.size) {
                            1 -> when (it.first()) {
                                Location.Type.STATION -> HciLocation.Type.STATION
                                Location.Type.ADDRESS,
                                Location.Type.PLACE -> HciLocation.Type.ADDRESS
                                Location.Type.POI -> HciLocation.Type.POI
                                Location.Type.POINT -> HciLocation.Type.COORD
                            }
                            2 -> when {
                                it.contains(Location.Type.STATION)
                                        && it.contains(Location.Type.ADDRESS) -> HciLocation.Type.STATION_ADDRESS
                                it.contains(Location.Type.STATION)
                                        && it.contains(Location.Type.POI) -> HciLocation.Type.STATION_POI
                                it.contains(Location.Type.ADDRESS)
                                        && it.contains(Location.Type.POI) -> HciLocation.Type.ADDRESS_POI
                                else -> null
                            }
                            else -> null
                        }
                    }
                ),
                field = HciLocationField.S,
                maxLoc = maxResults
            ),
            locFltrL = locationFilters.orEmpty()
        )
        try {
            val hciResponse = consumer.serviceRequest(hciRequest) ?: return ServiceResult.noResult()
            return withCommon(hciResponse.common) {
                if (hciResponse.match.locL.isEmpty()) {
                    return ServiceResult.noResult()
                }
                val response = LocationListData(
                    header = DataHeader(),
                    locations = hciResponse.match.locL.map { it.asCommon(this) }
                )
                ServiceResult.success(response)
            }
        } catch (e: HciException) {
            println(e)
            return ServiceResult.failure(
                e, when (e) {
                    else -> null
                }, e.message
            )
        }
    }

}