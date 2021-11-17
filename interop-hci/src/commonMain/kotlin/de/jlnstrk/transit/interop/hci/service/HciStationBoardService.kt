package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.api.hci.HciConsumer
import de.jlnstrk.transit.api.hci.HciException
import de.jlnstrk.transit.api.hci.method.stationboard.HciStationBoardRequest
import de.jlnstrk.transit.api.hci.request.filter.HciJourneyFilter
import de.jlnstrk.transit.api.hci.request.filter.HciRequestFilterMode
import de.jlnstrk.transit.api.hci.response.HciServiceError
import de.jlnstrk.transit.interop.hci.HciInteropService
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.extensions.asHci
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDateTime
import de.jlnstrk.transit.util.OffsetDateTime
import de.jlnstrk.transit.util.model.Line
import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.util.model.ProductClass
import de.jlnstrk.transit.util.response.StationBoardData
import de.jlnstrk.transit.util.response.base.ServiceResult
import de.jlnstrk.transit.util.service.StationBoardResult
import de.jlnstrk.transit.util.service.StationBoardService

internal class HciStationBoardService(
    provider: HciProvider,
    endpoint: HciConsumer
) : HciInteropService(provider, endpoint), StationBoardService {
    override val supportedModes: Set<StationBoardService.Mode> = setOf(
        StationBoardService.Mode.ARRIVALS,
        StationBoardService.Mode.DEPARTURES
    )
    override val supportedLocationTypes: Set<Location.Type> = setOf(
        Location.Type.STATION,
        Location.Type.POI,
        Location.Type.ADDRESS,
        Location.Type.PLACE,
    )

    override val supportsDateTime: Boolean get() = true
    override val supportsMaxDuration: Boolean get() = true
    override val supportsFilterProducts: Boolean get() = true
    override val supportsMaxResults: Boolean get() = true

    override suspend fun stationBoard(
        mode: StationBoardService.Mode,
        location: Location,
        direction: Location?,
        dateTime: OffsetDateTime?,
        filterProducts: Set<ProductClass>?,
        filterLines: Set<Line>?,
        maxDuration: Duration?,
        maxResults: Int?
    ): StationBoardResult {
        val inProviderZone = dateTime?.toOffset(provider.timezone)?.local
        val request = HciStationBoardRequest {
            stbLoc = location.asHci()
            type = when (mode) {
                StationBoardService.Mode.ARRIVALS -> HciStationBoardRequest.Type.ARR
                StationBoardService.Mode.DEPARTURES -> HciStationBoardRequest.Type.DEP
            }
            date = inProviderZone?.date
            time = inProviderZone?.time
            maxJny = maxResults

            val journeyFilters = mutableListOf<HciJourneyFilter>()
            filterProducts?.let {
                journeyFilters.add(
                    HciJourneyFilter(
                        type = HciJourneyFilter.Type.PROD,
                        mode = HciRequestFilterMode.INCLUSIVE,
                        value = provider.setToBitmask(it).toString()
                    )
                )
            }
            jnyFltrL = journeyFilters
        }
        try {
            val hciResult = endpoint.serviceRequest(request) ?: return ServiceResult.noResult()
            if (hciResult.jnyL.isEmpty()) {
                return ServiceResult.noResult()
            }
            return withCommon(hciResult.common) {
                val serviceResponse = StationBoardData(
                    dateTime = LocalDateTime(hciResult.sD, hciResult.sT)
                        .toOffsetUnadjusted(provider.timezone),
                    isArrivalBoard = when (hciResult.type) {
                        HciStationBoardRequest.Type.ARR,
                        HciStationBoardRequest.Type.ARR_EQUIVS,
                        HciStationBoardRequest.Type.ARR_MAST,
                        HciStationBoardRequest.Type.ARR_STATION -> true
                        else -> false
                    },
                    journeys = hciResult.jnyL.map { convertJourney(it, null) }
                )
                ServiceResult.success(serviceResponse)
            }
        } catch (e: HciException) {
            println(e)
            return ServiceResult.failure(
                e, when (e) {
                    is HciException.Service -> when (e.serviceError) {
                        HciServiceError.LOCATION,
                        HciServiceError.NO_STATIONS_NEARBY -> StationBoardService.Error.INVALID_LOCATION
                        HciServiceError.DATE_OUT_OF_RANGE -> StationBoardService.Error.INVALID_DATETIME
                        else -> null
                    }
                    else -> null
                }, e.message
            )
        } catch (e: Exception) {
            if (e::class.simpleName == "JsonDataException") {
                e.printStackTrace()
                return ServiceResult.noResult()
            } else throw e
        }
    }

}