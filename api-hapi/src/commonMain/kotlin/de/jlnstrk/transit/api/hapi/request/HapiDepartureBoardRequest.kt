package de.jlnstrk.transit.api.hapi.request

import de.jlnstrk.transit.api.hapi.HapiService
import de.jlnstrk.transit.api.hapi.response.HapiDepartureBoard

public class HapiDepartureBoardRequest : HapiStationBoardRequest<HapiDepartureBoard>() {
    override val service: HapiService get() = HapiService.DEPARTURE_BOARD

    public companion object {
        public inline operator fun invoke(init: HapiDepartureBoardRequest.() -> Unit): HapiDepartureBoardRequest =
            HapiDepartureBoardRequest().apply(init)
    }
}