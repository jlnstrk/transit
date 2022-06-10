package de.jlnstrk.transit.interop.efa.service

import de.jlnstrk.transit.client.efa.EfaClient
import de.jlnstrk.transit.client.efa.endpoint.dm.EfaDmRequest
import de.jlnstrk.transit.client.efa.request.EfaDateTimeMode
import de.jlnstrk.transit.client.efa.util.efaDmRequest
import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.Line
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.ProductClass
import de.jlnstrk.transit.common.response.StationBoardData
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.StationBoardResult
import de.jlnstrk.transit.common.service.StationBoardService
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.EfaService
import de.jlnstrk.transit.interop.efa.normalization.generic.denormalize
import de.jlnstrk.transit.interop.efa.normalization.generic.normalize
import kotlinx.datetime.Instant
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration

internal class EfaStationBoardService(
    provider: EfaProvider,
    client: EfaClient
) : EfaService(provider, client), StationBoardService {
    override val supportedModes: Set<StationBoardService.Mode> = setOf(
        StationBoardService.Mode.ARRIVALS,
        StationBoardService.Mode.DEPARTURES
    )
    override val supportedLocationTypes: Set<Location.Type> = setOf(
        Location.Type.STATION,
        Location.Type.POINT
    )

    override val supportsDateTime: Boolean = true
    override val supportsFilterProducts: Boolean = true

    override suspend fun stationBoard(
        mode: StationBoardService.Mode,
        location: Location,
        direction: Location?,
        dateTime: Instant?,
        filterProducts: Set<ProductClass>?,
        filterLines: Set<Line>?,
        maxDuration: Duration?,
        maxResults: Int?
    ): StationBoardResult {
        val dateTimeAtServer = dateTime?.toLocalDateTime(provider.timezone)
        val point = with(provider) { location.denormalize(provider) }
        val efaRequest = efaDmRequest {
            dm(point) {
                // TODO: Options?
            }

            if (dateTimeAtServer != null) {
                itdDate = dateTimeAtServer.date
                itdTime = dateTimeAtServer.time
            }
            itdDateTimeDepArr = when (mode) {
                StationBoardService.Mode.ARRIVALS -> EfaDateTimeMode.ARRIVAL
                StationBoardService.Mode.DEPARTURES -> EfaDateTimeMode.DEPARTURE
            }
            if (filterProducts != null) {
                includedMeans = provider.denormalizeEfaMeans(filterProducts)
            }
            if (maxResults != null) {
                limit = maxResults
            }
            useRealtime = true
            modeDirect = true
            depType = EfaDmRequest.DepartureType.STOP_EVENTS
            includeCompleteStopSeq = true
        }
        try {
            val efaResponse = client.xmlDmRequest(efaRequest)
            if (efaResponse.arrivalList.isEmpty() && efaResponse.departureList.isEmpty()) {
                return ServiceResult.noResult()
            }
            val data = with(provider) {
                StationBoardData(
                    header = DataHeader(),
                    dateTime = efaResponse.dateTime.dateTime.toInstant(provider.timezone),
                    isArrivalBoard = efaResponse.dateTime.mode == EfaDateTimeMode.ARRIVAL,
                    journeys = when (efaResponse.dateTime.mode) {
                        EfaDateTimeMode.ARRIVAL -> efaResponse.arrivalList
                        EfaDateTimeMode.DEPARTURE,
                        EfaDateTimeMode.FIRST_SERVICE,
                        EfaDateTimeMode.LAST_SERVICE -> efaResponse.departureList
                    }.map { efaJourney ->
                        efaJourney.normalize(provider, efaResponse.dateTime.mode)
                    },
                    scrollContext = null,
                )
            }
            return ServiceResult.success(data)
        } catch (e: Exception) {
            e.printStackTrace()
            e.cause?.printStackTrace()
            return ServiceResult.failure(e, message = e.message)
        }
    }
}