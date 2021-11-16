package de.jlnstrk.transit.interop.efa.service

import de.jlnstrk.transit.api.efa.EfaEndpoint
import de.jlnstrk.transit.api.efa.endpoint.dm.EfaDmRequest
import de.jlnstrk.transit.api.efa.request.EfaRequest
import de.jlnstrk.transit.api.efa.util.efaDmRequest
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.OffsetDateTime
import de.jlnstrk.transit.util.model.Line
import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.util.model.ProductClass
import de.jlnstrk.transit.util.response.StationBoardData
import de.jlnstrk.transit.util.response.base.ServiceResult
import de.jlnstrk.transit.util.service.StationBoardResult
import de.jlnstrk.transit.util.service.StationBoardService
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.EfaService
import de.jlnstrk.transit.interop.efa.normalization.generic.denormalize
import de.jlnstrk.transit.interop.efa.normalization.generic.normalize

internal class EfaStationBoardService(
    provider: EfaProvider,
    client: EfaEndpoint
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
        dateTime: OffsetDateTime?,
        filterProducts: Set<ProductClass>?,
        filterLines: Set<Line>?,
        maxDuration: Duration?,
        maxResults: Int?
    ): StationBoardResult {
        val dateTimeAtServer = dateTime?.toOffset(provider.timezone)?.local
        val point = location.denormalize(provider)
        val efaRequest = efaDmRequest {
            dm(point) {
                // TODO: Options?
            }

            if (dateTimeAtServer != null) {
                itdDate = dateTimeAtServer.date
                itdTime = dateTimeAtServer.time
            }
            itdDateTimeDepArr = when (mode) {
                StationBoardService.Mode.ARRIVALS -> EfaRequest.DateTimeMode.ARRIVAL
                StationBoardService.Mode.DEPARTURES -> EfaRequest.DateTimeMode.DEPARTURE
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
            val efaResponse = endpoint.xmlDmRequest(efaRequest)
            if (efaResponse.arrivalList.isNullOrEmpty()
                && efaResponse.departureList.isNullOrEmpty()
            ) {
                return ServiceResult.noResult()
            }
            val result = StationBoardData(
                dateTime = OffsetDateTime.local(efaResponse.dateTime.dateTime, provider.timezone),
                isArrivalBoard = efaResponse.dateTime.mode == EfaRequest.DateTimeMode.ARRIVAL,
                journeys = when (efaResponse.dateTime.mode) {
                    EfaRequest.DateTimeMode.ARRIVAL -> efaResponse.arrivalList
                    EfaRequest.DateTimeMode.DEPARTURE,
                    EfaRequest.DateTimeMode.FIRST_SERVICE,
                    EfaRequest.DateTimeMode.LAST_SERVICE -> efaResponse.departureList
                }!!.map { efaJourney ->
                    efaJourney.normalize(provider, efaResponse.dateTime.mode)
                })
            return ServiceResult.success(result)
        } catch (e: Exception) {
            e.printStackTrace()
            e.cause?.printStackTrace()
            return ServiceResult.failure(e, message = e.message)
        }
    }
}