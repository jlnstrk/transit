package de.jlnstrk.transit.interop.hapi.service

import de.jlnstrk.transit.api.hapi.request.HapiArrivalBoardRequest
import de.jlnstrk.transit.api.hapi.request.HapiDepartureBoardRequest
import de.jlnstrk.transit.api.hapi.request.base.HapiFilterList
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.OffsetDateTime
import de.jlnstrk.transit.util.model.Line
import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.util.model.ProductClass
import de.jlnstrk.transit.util.response.StationBoardData
import de.jlnstrk.transit.util.response.base.ServiceResult
import de.jlnstrk.transit.util.service.StationBoardResult
import de.jlnstrk.transit.util.service.StationBoardService
import de.jlnstrk.transit.interop.hapi.HapiProvider
import de.jlnstrk.transit.interop.hapi.HapiService

internal class HapiStationBoardService(
    provider: HapiProvider,
    endpoint: de.jlnstrk.transit.api.hapi.HapiClient
) : HapiService(provider, endpoint), StationBoardService {

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
        val hapiRequest = when (mode) {
            StationBoardService.Mode.DEPARTURES -> HapiDepartureBoardRequest()
            StationBoardService.Mode.ARRIVALS -> HapiArrivalBoardRequest()
        }.apply {
            dateTime?.let {
                date = it.local.date
                time = it.local.time
            }
            filterProducts?.let {
                products = provider.setToBitmask(it)
            }
            filterLines?.let {
                lines = HapiFilterList(included = it.mapNotNull(Line::name))
            }
            duration = maxDuration
            maxJourneys = maxResults
        }

        when (hapiRequest) {
            is HapiDepartureBoardRequest -> {
                val hapiResponse = endpoint.hapiRequest(hapiRequest)
                val data = StationBoardData(
                    dateTime = null,
                    isArrivalBoard = false,
                    journeys = emptyList()
                )
                return ServiceResult.success(data)
            }
            is HapiArrivalBoardRequest -> {
                val hapiResponse = endpoint.hapiRequest(hapiRequest)
                val data = StationBoardData(
                    dateTime = null,
                    isArrivalBoard = true,
                    journeys = emptyList()
                )
                return ServiceResult.success(data)
            }
        }
    }
}