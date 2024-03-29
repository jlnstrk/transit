package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.api.hci.HciConsumer
import de.jlnstrk.transit.api.hci.HciException
import de.jlnstrk.transit.api.hci.method.tripsearch.HciTripSearchRequest
import de.jlnstrk.transit.api.hci.method.tripsearch.HciTripSearchResult
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.request.filter.HciJourneyFilter
import de.jlnstrk.transit.api.hci.request.filter.HciRequestFilterMode
import de.jlnstrk.transit.api.hci.response.HciServiceError
import de.jlnstrk.transit.common.model.*
import de.jlnstrk.transit.common.response.TripSearchData
import de.jlnstrk.transit.common.response.base.ScrollContext
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.TripSearchResult
import de.jlnstrk.transit.common.service.TripSearchService
import de.jlnstrk.transit.interop.hci.HciInteropService
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.conversion.asCommon
import de.jlnstrk.transit.interop.hci.conversion.asHci
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.OffsetDateTime

internal class HciTripSearchService(
    provider: HciProvider,
    consumer: HciConsumer
) : HciInteropService(provider, consumer), TripSearchService {
    override val supportedOriginTypes: Set<Location.Type> = setOf(
        Location.Type.STATION,
        Location.Type.ADDRESS,
        Location.Type.POI,
        Location.Type.POINT
    )
    override val supportedDestinationTypes: Set<Location.Type> = setOf(
        Location.Type.STATION,
        Location.Type.ADDRESS,
        Location.Type.POI,
        Location.Type.POINT
    )
    override val supportedViaTypes: Set<Location.Type> = setOf(
        Location.Type.STATION
    )
    override val supportedViaCount: Int get() = 3

    override val supportsDateTime: Boolean get() = true
    override val supportsDateTimeMode: Boolean get() = true
    override val supportsFilterProducts: Boolean get() = true
    override val supportsIncludePolylines: Boolean get() = true
    override val supportsIncludeStops: Boolean get() = true
    override val supportsMaxResults: Boolean get() = true

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
        val providerDateTime = dateTime?.toOffset(provider.timezone)?.local
        val journeyFilters = mutableListOf<HciJourneyFilter>()
        filterProducts?.let {
            journeyFilters.add(
                HciJourneyFilter(
                    type = HciJourneyFilter.Type.PROD,
                    mode = HciRequestFilterMode.INC,
                    value = provider.setToBitmask(it).toString()
                )
            )
        }
        val departureLocations = listOf(origin.asHci())
        val arrivalLocations = listOf(destination.asHci())
        val viaLocations = via?.map {
            HciTripSearchRequest.Via(
                loc = it.location.asHci(),
                min = it.period
            )
        }
        println(dateTime)
        println(providerDateTime)
        println(provider.timezone)
        val request = HciTripSearchRequest {
            depLocL = departureLocations
            arrLocL = arrivalLocations
            viaLocL = viaLocations.orEmpty()
            outDate = providerDateTime?.date
            outTime = providerDateTime?.time
            getPolyline = includePolylines
            getPasslist = includeStops
            getPT = true
            getIV = true
            liveSearch = true
            ushrp = true
            jnyFltrL = journeyFilters.orEmpty()
        }
        try {
            val hciResponse = consumer.serviceRequest(request) ?: return ServiceResult.noResult()
            val result = TripSearchData(
                header = DataHeader(),
                trips = convertTrips(hciResponse),
                scrollContext = Context(
                    contextScrollBackward = hciResponse.outCtxScrB,
                    contextScrollForward = hciResponse.outCtxScrF,
                    departureLocations = departureLocations,
                    arrivalLocations = arrivalLocations,
                    viaLocations = viaLocations
                )
            )
            return ServiceResult.success(result)
        } catch (e: HciException) {
            println(e)
            return ServiceResult.failure(
                e, when (e) {
                    else -> null
                }, e.message
            )
        }
    }

    override suspend fun tripSearchScroll(
        scrollContext: ScrollContext<TripSearchData>,
        scrollBackward: Boolean
    ): TripSearchResult {
        if (scrollContext !is Context) return ServiceResult.failure()
        val request = HciTripSearchRequest(
            depLocL = scrollContext.departureLocations,
            arrLocL = scrollContext.arrivalLocations,
            viaLocL = scrollContext.viaLocations.orEmpty(),
            ctxScr = when (scrollBackward) {
                true -> scrollContext.contextScrollBackward
                false -> scrollContext.contextScrollForward
            }
        )
        try {
            val hciResponse = consumer.serviceRequest(request) ?: return ServiceResult.noResult()
            val response = TripSearchData(
                header = DataHeader(),
                trips = convertTrips(hciResponse),
                scrollContext = scrollContext.copy(
                    contextScrollBackward = hciResponse.outCtxScrB,
                    contextScrollForward = hciResponse.outCtxScrF
                )
            )
            return ServiceResult.success(response)
        } catch (e: HciException) {
            println(e)
            return ServiceResult.failure(
                e, when (e) {
                    is HciException.Service -> when (e.serviceError) {
                        HciServiceError.LOCATION -> TripSearchService.Error.INVALID_LOCATION
                        else -> null
                    }
                    else -> {
                        println(e)
                        null
                    }
                }, e.message
            )
        }
    }

    private suspend fun convertTrips(
        hciResult: HciTripSearchResult
    ): List<Trip> {
        return withCommon(hciResult.common) {
            hciResult.outConL.map { it.asCommon(this) }
        }
    }

    private data class Context(
        val contextScrollBackward: String?,
        val contextScrollForward: String?,
        val departureLocations: List<HciLocation>,
        val arrivalLocations: List<HciLocation>,
        val viaLocations: List<HciTripSearchRequest.Via>?
    ) : ScrollContext<TripSearchData> {
        override val canScrollBackward: Boolean
            get() = contextScrollBackward != null
        override val canScrollForward: Boolean
            get() = contextScrollForward != null
    }
}