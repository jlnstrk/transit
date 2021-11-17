package de.jlnstrk.transit.interop.efa.service

import de.jlnstrk.transit.api.efa.EfaClient
import de.jlnstrk.transit.api.efa.model.EfaCoordinateSystem
import de.jlnstrk.transit.api.efa.model.EfaCoordinates
import de.jlnstrk.transit.api.efa.model.EfaPin
import de.jlnstrk.transit.api.efa.util.efaCoordRequest
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.EfaService
import de.jlnstrk.transit.interop.efa.normalization.generic.normalize
import de.jlnstrk.transit.util.model.Attribute
import de.jlnstrk.transit.util.model.Coordinates
import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.util.model.ProductClass
import de.jlnstrk.transit.util.response.LocationListData
import de.jlnstrk.transit.util.response.base.ServiceResult
import de.jlnstrk.transit.util.service.NearbyLocationsService

internal class EfaNearbyLocationsService(
    provider: EfaProvider,
    client: EfaClient
) : EfaService(provider, client), NearbyLocationsService {
    override val supportsFilterTypes: Boolean get() = true
    override val supportsFilterProducts: Boolean get() = true
    override val supportsFilterAttributes: Boolean get() = true
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
        val efaRequest = efaCoordRequest {
            coord = EfaCoordinates(
                x = coordinates.longitude,
                y = coordinates.latitude,
                mapName = EfaCoordinateSystem.WGS84_DECIMAL
            )

            if (filterTypes != null) {
                filterTypes.mapNotNull {
                    when (it) {
                        Location.Type.STATION -> EfaPin.Type.STOP
                        Location.Type.ADDRESS -> EfaPin.Type.STREET
                        Location.Type.POI -> EfaPin.Type.POI_POINT
                        else -> null
                    }
                }.forEach {
                    addFilter {
                        type = it
                        radius = maxDistance
                    }
                }
            } else {
                addFilter {
                    radius = maxDistance
                }
            }
            if (filterProducts != null) {
                includedMeans = provider.denormalizeEfaMeans(filterProducts)
            }
            max = maxResults
        }
        try {
            val efaResponse = client.xmlCoordRequest(efaRequest)
            if (efaResponse.pins.isEmpty()) {
                return ServiceResult.noResult()
            }
            val result = LocationListData(
                efaResponse.pins.map { it.normalize(provider) }
            )
            return ServiceResult.success(result)
        } catch (e: Exception) {
            e.printStackTrace()
            e.cause?.printStackTrace()
            return ServiceResult.failure(e, message = e.message)
        }
    }
}