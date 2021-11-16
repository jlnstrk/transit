package de.jlnstrk.transit.interop.efa.service

import de.jlnstrk.transit.api.efa.EfaEndpoint
import de.jlnstrk.transit.api.efa.endpoint.trip.EfaTripRequest
import de.jlnstrk.transit.api.efa.request.EfaRequest
import de.jlnstrk.transit.api.efa.util.efaTripRequest
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.OffsetDateTime
import de.jlnstrk.transit.util.model.*
import de.jlnstrk.transit.util.response.TripSearchData
import de.jlnstrk.transit.util.response.base.ScrollContext
import de.jlnstrk.transit.util.response.base.ServiceResult
import de.jlnstrk.transit.util.service.TripSearchResult
import de.jlnstrk.transit.util.service.TripSearchService
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.EfaService
import de.jlnstrk.transit.interop.efa.normalization.generic.denormalize
import de.jlnstrk.transit.interop.efa.normalization.generic.normalize

internal class EfaTripSearchService(
    provider: EfaProvider,
    client: EfaEndpoint
) : EfaService(provider, client), TripSearchService {

    override val supportedOriginTypes: Set<Location.Type> = setOf(
        Location.Type.STATION,
        Location.Type.ADDRESS,
        Location.Type.POI,
        Location.Type.PLACE
    )
    override val supportedDestinationTypes: Set<Location.Type> = setOf(
        Location.Type.STATION,
        Location.Type.ADDRESS,
        Location.Type.POI,
        Location.Type.PLACE
    )
    override val supportedViaTypes: Set<Location.Type> = setOf(
        Location.Type.STATION,
        Location.Type.ADDRESS,
        Location.Type.POI,
        Location.Type.PLACE
    )
    override val supportedViaCount: Int = 1

    override suspend fun tripSearch(
        origin: Location,
        destination: Location,
        via: List<Via>?,
        viaPeriod: Duration?,
        viaModes: Set<Via.Mode>?,
        dateTime: OffsetDateTime?,
        dateTimeIsArrival: Boolean?,
        filterProducts: Set<ProductClass>?,
        filterLines: Set<Line>?,
        includePolylines: Boolean?,
        includeStops: Boolean?,
        maxResults: Int?
    ): TripSearchResult {
        val efaOrigin = origin.denormalize(provider)
        val efaDestination = destination.denormalize(provider)

        val efaRequest = efaTripRequest {
            origin(efaOrigin) {
                // TODO: Options?
            }
            destination(efaDestination) {
                // TODO: Options?
            }
            via?.forEach {
                val efaVia = it.location.denormalize(provider)
                via(efaVia) {
                    // TODO: Options?
                }
            }

            itdTripDateTimeDepArr = when (dateTimeIsArrival) {
                null, false -> EfaRequest.DateTimeMode.DEPARTURE
                else -> EfaRequest.DateTimeMode.ARRIVAL
            }

            if (dateTime != null) {
                val atProviderZone = dateTime.toOffset(provider.timezone).local
                itdDate = atProviderZone.date
                itdTime = atProviderZone.time
            }

            useRealtime = true

            if (filterProducts != null) {
                includedMeans = provider.denormalizeEfaMeans(filterProducts)
            }

            publicTransportOptions {
                useProxFootSearch = true
            }
            individualTransportOptions {
                trlTMOT = EfaTripRequest.ItOptions.Means.values().toSet()
            }

            calcOneDirection = true
            calcNumberOfTrips = maxResults
        }

        efaRequest.entries.forEach {
            println("${it.key} : ${it.value}")
        }

        try {
            val efaResponse = endpoint.xmlTripRequest2(efaRequest)
            if (efaResponse.trips.isNullOrEmpty()) {
                return ServiceResult.noResult()
            }
            val result = TripSearchData(
                trips = efaResponse.trips!!.map { it.normalize(provider) }
            )
            return ServiceResult.success(result)
        } catch (e: Exception) {
            throw e
            e.printStackTrace()
            e.cause?.printStackTrace()
            return ServiceResult.failure(e, message = e.message)
        }
    }

    override suspend fun tripSearchScroll(
        scrollContext: ScrollContext<TripSearchData>,
        scrollBackward: Boolean
    ): TripSearchResult {
        return ServiceResult.failure()
    }

}