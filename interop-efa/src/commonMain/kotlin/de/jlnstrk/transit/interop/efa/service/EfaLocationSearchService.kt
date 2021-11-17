package de.jlnstrk.transit.interop.efa.service

import de.jlnstrk.transit.api.efa.EfaClient
import de.jlnstrk.transit.api.efa.model.EfaPoint
import de.jlnstrk.transit.api.efa.response.EfaPointVerification
import de.jlnstrk.transit.api.efa.util.efaStopFinderRequest
import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.ProductClass
import de.jlnstrk.transit.common.response.LocationListData
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.LocationSearchResult
import de.jlnstrk.transit.common.service.LocationSearchService
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.EfaService
import de.jlnstrk.transit.interop.efa.normalization.generic.normalize
import de.jlnstrk.transit.interop.efa.util.denormalized

internal class EfaLocationSearchService(
    provider: EfaProvider,
    client: EfaClient
) : EfaService(provider, client), LocationSearchService {
    override val supportsFilterTypes: Boolean get() = true
    override val supportsFilterProducts: Boolean get() = true

    override suspend fun locationSearch(
        query: String,
        filterTypes: Set<Location.Type>?,
        filterProducts: Set<ProductClass>?,
        maxResults: Int?
    ): LocationSearchResult {
        val request = efaStopFinderRequest {
            val point = EfaPoint.Any(name = "$query?", type = EfaPointVerification.Type.ANY)
            sf(point) {
                if (filterTypes != null) {
                    objectFilter = filterTypes.denormalized()
                }
            }
            if (filterProducts != null) {
                includedMeans = provider.denormalizeEfaMeans(filterProducts)
            }
            if (maxResults != null) {
                anyMaxSizeHitList = maxResults
            }
        }
        try {
            val efaResponse = client.xmlStopFinderRequest(request)
            val points = efaResponse.stopFinder.points
            if (points.isNullOrEmpty()) {
                return ServiceResult.noResult()
            }
            val result = LocationListData(
                header = DataHeader(),
                locations = points.map { it.normalize(provider) }
            )
            return ServiceResult.success(result)
        } catch (e: Exception) {
            e.printStackTrace()
            e.cause?.printStackTrace()
            return ServiceResult.failure(e, message = e.message)
        }
    }
}