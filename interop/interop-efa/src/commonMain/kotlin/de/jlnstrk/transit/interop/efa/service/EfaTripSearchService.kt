package de.jlnstrk.transit.interop.efa.service

import de.jlnstrk.transit.client.efa.EfaClient
import de.jlnstrk.transit.client.efa.endpoint.trip.EfaTripRequest
import de.jlnstrk.transit.client.efa.request.EfaDateTimeMode
import de.jlnstrk.transit.client.efa.util.efaTripRequest
import de.jlnstrk.transit.common.model.*
import de.jlnstrk.transit.common.response.TripSearchData
import de.jlnstrk.transit.common.response.base.ScrollContext
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.TripSearchResult
import de.jlnstrk.transit.common.service.TripSearchService
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.EfaService
import de.jlnstrk.transit.interop.efa.normalization.generic.denormalize
import de.jlnstrk.transit.interop.efa.normalization.generic.normalize
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.OffsetDateTime

internal class EfaTripSearchService(
    provider: EfaProvider,
    client: EfaClient
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
        via: List<Via>,
        viaPeriod: Duration?,
        viaModes: Set<Via.Mode>?,
        dateTime: OffsetDateTime?,
        dateTimeIsArrival: Boolean?,
        filterProducts: ProductSet?,
        filterLines: LineSet?,
        includePolylines: Boolean?,
        includeStops: Boolean?,
        maxResults: Int?
    ): TripSearchResult {
        val efaOrigin = with(provider) { origin.denormalize(provider) }
        val efaDestination = with(provider) { destination.denormalize(provider) }

        val efaRequest = efaTripRequest {
            origin(efaOrigin) {
                // TODO: Options?
            }
            destination(efaDestination) {
                // TODO: Options?
            }
            via.forEach {
                val efaVia = with (provider) { it.location.denormalize(provider) }
                via(efaVia) {
                    // TODO: Options?
                }
            }

            itdTripDateTimeDepArr = when (dateTimeIsArrival) {
                null, false -> EfaDateTimeMode.DEPARTURE
                else -> EfaDateTimeMode.ARRIVAL
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
            val efaResponse = client.xmlTripRequest2(efaRequest)
            if (efaResponse.trips.isEmpty()) {
                return ServiceResult.noResult()
            }
            val result = with(provider) {
                TripSearchData(
                    header = DataHeader(),
                    trips = efaResponse.trips.map {
                        it.normalize(provider)
                    },
                    scrollContext = null,
                )
            }
            return ServiceResult.success(result)
        } catch (e: Exception) {
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