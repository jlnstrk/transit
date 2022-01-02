package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.client.hci.HciConsumer
import de.jlnstrk.transit.client.hci.HciException
import de.jlnstrk.transit.client.hci.method.locmatch.HciLocMatchServiceRequest
import de.jlnstrk.transit.client.hci.method.locmatch.HciLocMatchServiceResult
import de.jlnstrk.transit.client.hci.model.location.*
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

internal fun Set<Location.Type>.toHciLocationType(): HciLocationType = when {
    Location.Type.STATION in this
            && Location.Type.ADDRESS in this
            && Location.Type.POI in this -> HciLocationType.SAP
    Location.Type.STATION in this
            && Location.Type.ADDRESS in this -> HciLocationType.SA
    Location.Type.STATION in this
            && Location.Type.POI in this -> HciLocationType.SP
    Location.Type.ADDRESS in this
            && Location.Type.POI in this -> HciLocationType.AP
    Location.Type.STATION in this -> HciLocationType.S
    Location.Type.ADDRESS in this -> HciLocationType.A
    Location.Type.POI in this -> HciLocationType.P
    else -> HciLocationType.ALL
}

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
                    type = HciLocationFilterType.PROD,
                    mode = HciLocationFilterMode.INC,
                    value = provider.setToBitmask(it).toString()
                )
            )
        }
        val hciRequest = HciLocMatchServiceRequest(
            input = HciLocationInput(
                loc = HciLocation(
                    name = "$query?",
                    type = filterTypes.orEmpty().toHciLocationType()
                ),
                field = HciLocationField.S,
                maxLoc = maxResults ?: -1
            ),
            getProducts = true
            // TODO: locFltrL = locationFilters.orEmpty()
        )
        try {
            val hciResponse =
                consumer.serviceRequest<HciLocMatchServiceResult>(hciRequest) ?: return ServiceResult.noResult()
            return withCommon(hciResponse.common!!) {
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