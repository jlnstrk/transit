package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.client.hci.HciConsumer
import de.jlnstrk.transit.client.hci.HciException
import de.jlnstrk.transit.client.hci.method.stationboard.HciStationBoardServiceRequest
import de.jlnstrk.transit.client.hci.method.stationboard.HciStationBoardServiceResult
import de.jlnstrk.transit.client.hci.model.HciServiceError
import de.jlnstrk.transit.client.hci.model.HciStationBoardType
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilterMode
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilterType
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.Line
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.ProductClass
import de.jlnstrk.transit.common.response.StationBoardData
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.StationBoardResult
import de.jlnstrk.transit.common.service.StationBoardService
import de.jlnstrk.transit.interop.hci.HciInteropService
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.conversion.asCommon
import de.jlnstrk.transit.interop.hci.conversion.asHci
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDateTime
import de.jlnstrk.transit.util.OffsetDateTime

internal class HciStationBoardService(
    provider: HciProvider,
    consumer: HciConsumer
) : HciInteropService(provider, consumer), StationBoardService {
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
        val request = HciStationBoardServiceRequest {
            stbLoc = location.asHci()
            type = when (mode) {
                StationBoardService.Mode.ARRIVALS -> HciStationBoardType.ARR
                StationBoardService.Mode.DEPARTURES -> HciStationBoardType.DEP
            }
            date = inProviderZone?.date
            time = inProviderZone?.time?.let { HciLocalTime(it, 0) }
            maxJny = maxResults

            val journeyFilters = mutableListOf<HciJourneyFilter>()
            filterProducts?.let {
                journeyFilters.add(
                    HciJourneyFilter(
                        type = HciJourneyFilterType.PROD,
                        mode = HciJourneyFilterMode.INC,
                        value = provider.setToBitmask(it).toString()
                    )
                )
            }
            jnyFltrL = journeyFilters
        }
        try {
            val hciResult =
                consumer.serviceRequest<HciStationBoardServiceResult>(request) ?: return ServiceResult.noResult()
            if (hciResult.jnyL.isEmpty()) {
                return ServiceResult.noResult()
            }
            return withCommon(hciResult.common!!) {
                val serviceResponse = StationBoardData(
                    header = DataHeader(),
                    dateTime = null,
                    /*dateTime = LocalDateTime(hciResult.sD, hciResult.sT)
                        .toOffsetUnadjusted(provider.timezone),*/
                    isArrivalBoard = when (hciResult.type) {
                        HciStationBoardType.ARR,
                        HciStationBoardType.ARR_EQUIVS,
                        HciStationBoardType.ARR_MAST,
                        HciStationBoardType.ARR_STATION -> true
                        else -> false
                    },
                    journeys = hciResult.jnyL.map { it.asCommon(this, null) },
                    scrollContext = null,
                )
                ServiceResult.success(serviceResponse)
            }
        } catch (e: HciException) {
            println(e)
            return ServiceResult.failure(
                e, when (e) {
                    is HciException.Service -> when (e.serviceError) {
                        HciServiceError.LOCATION,
                            /*HciServiceError.NO_STATIONS_NEARBY*/
                        -> StationBoardService.Error.INVALID_LOCATION
                        //HciServiceError.DATE_OUT_OF_RANGE -> StationBoardService.Error.INVALID_DATETIME
                        else -> null
                    }
                    else -> null
                }, e.message
            )
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.failure(e, message = e.message)
        }
    }

}