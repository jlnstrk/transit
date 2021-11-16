package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.api.hci.HciEndpoint
import de.jlnstrk.transit.api.hci.HciException
import de.jlnstrk.transit.api.hci.method.locmatch.HciLocMatchRequest
import de.jlnstrk.transit.api.hci.model.location.HciLocationInput
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.model.location.HciLocationField
import de.jlnstrk.transit.api.hci.request.filter.HciLocationFilter
import de.jlnstrk.transit.api.hci.request.filter.HciRequestFilterMode
import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.util.model.ProductClass
import de.jlnstrk.transit.util.response.LocationListData
import de.jlnstrk.transit.util.response.base.ServiceResult
import de.jlnstrk.transit.util.service.LocationSearchResult
import de.jlnstrk.transit.util.service.LocationSearchService
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.HciInteropService

internal class HciLocationSearchService(
    provider: HciProvider,
    endpoint: HciEndpoint
) : HciInteropService(provider, endpoint), LocationSearchService {
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
                    mode = HciRequestFilterMode.INCLUSIVE,
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
            val hciResponse = endpoint.serviceRequest(hciRequest) ?: return ServiceResult.noResult()
            return withCommon(hciResponse.common) {
                if (hciResponse.match.locL.isEmpty()) {
                    return ServiceResult.noResult()
                }
                val response =
                    LocationListData(hciResponse.match.locL.map(::convertLocation))
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