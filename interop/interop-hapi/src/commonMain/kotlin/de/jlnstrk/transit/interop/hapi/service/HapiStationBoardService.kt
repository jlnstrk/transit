package de.jlnstrk.transit.interop.hapi.service

import de.jlnstrk.transit.client.hapi.HapiClient
import de.jlnstrk.transit.client.hapi.request.HapiArrivalBoardRequest
import de.jlnstrk.transit.client.hapi.request.HapiDepartureBoardRequest
import de.jlnstrk.transit.client.hapi.request.base.HapiFilterList
import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.Line
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.ProductClass
import de.jlnstrk.transit.common.response.StationBoardData
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.StationBoardResult
import de.jlnstrk.transit.common.service.StationBoardService
import de.jlnstrk.transit.interop.hapi.HapiProvider
import de.jlnstrk.transit.interop.hapi.HapiService
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.OffsetDateTime

internal class HapiStationBoardService(
    provider: HapiProvider,
    endpoint: HapiClient
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
                    header = DataHeader(),
                    dateTime = null,
                    isArrivalBoard = false,
                    journeys = emptyList(),
                    scrollContext = null
                )
                return ServiceResult.success(data)
            }
            is HapiArrivalBoardRequest -> {
                val hapiResponse = endpoint.hapiRequest(hapiRequest)
                val data = StationBoardData(
                    header = DataHeader(),
                    dateTime = null,
                    isArrivalBoard = true,
                    journeys = emptyList(),
                    scrollContext = null,
                )
                return ServiceResult.success(data)
            }
        }
    }
}