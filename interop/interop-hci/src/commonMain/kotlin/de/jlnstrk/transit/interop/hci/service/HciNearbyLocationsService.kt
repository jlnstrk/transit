package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.api.hci.HciConsumer
import de.jlnstrk.transit.api.hci.HciException
import de.jlnstrk.transit.api.hci.method.locgeopos.HciLocGeoPosRequest
import de.jlnstrk.transit.api.hci.model.geo.HciGeoRing
import de.jlnstrk.transit.api.hci.request.filter.HciLocationFilter
import de.jlnstrk.transit.api.hci.request.filter.HciRequestFilterMode
import de.jlnstrk.transit.common.model.*
import de.jlnstrk.transit.common.response.LocationListData
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.NearbyLocationsService
import de.jlnstrk.transit.interop.hci.HciInteropService
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.conversion.asCommon
import de.jlnstrk.transit.interop.hci.conversion.asHci

internal class HciNearbyLocationsService(
    provider: HciProvider,
    consumer: HciConsumer
) : HciInteropService(provider, consumer), NearbyLocationsService {
    override val supportsFilterTypes: Boolean get() = true
    override val supportsFilterProducts: Boolean get() = true
    override val supportsFilterAttributes: Boolean get() = true
    override val supportsMinDistance: Boolean get() = true
    override val supportsMaxDistance: Boolean get() = true
    override val supportsMaxResults: Boolean get() = true

    override suspend fun nearbyLocations(
        coordinates: Coordinates,
        filterTypes: Set<Location.Type>?,
        filterProducts: Set<ProductClass>?,
        filterAttributes: Set<Attribute>?,
        minDistance: Int?,
        maxDistance: Int?,
        maxResults: Int?
    ): ServiceResult<LocationListData, NearbyLocationsService.Error> {
        val locationFilters = filterProducts?.let {
            listOf(
                HciLocationFilter(
                    type = HciLocationFilter.Type.PROD,
                    mode = HciRequestFilterMode.INC,
                    value = provider.setToBitmask(it).toString()
                )
            )
        }
        val request = HciLocGeoPosRequest(
            ring = HciGeoRing(
                cCrd = coordinates.asHci(),
                minDist = minDistance,
                maxDist = maxDistance ?: -1
            ),
            getStops = filterTypes?.contains(Location.Type.STATION) ?: true,
            getPOIs = filterTypes?.contains(Location.Type.POI) ?: true,
            maxLoc = maxResults,
            locFltrL = locationFilters.orEmpty()
        )
        try {
            val serviceResponse = consumer.serviceRequest(request) ?: return ServiceResult.noResult()
            if (serviceResponse.locL.isEmpty()) {
                return ServiceResult.noResult()
            }
            return withCommon(serviceResponse.common) {
                val response = LocationListData(
                    header = DataHeader(),
                    locations = serviceResponse.locL.map { it.asCommon(this) }
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