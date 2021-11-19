package de.jlnstrk.transit.api.hapi.request

import de.jlnstrk.transit.api.hapi.HapiEndpoint
import de.jlnstrk.transit.api.hapi.response.HapiDepartureBoard

public class HapiDepartureBoardRequest : HapiStationBoardRequest<HapiDepartureBoard>() {
    override val service: HapiEndpoint get() = HapiEndpoint.DEPARTURE_BOARD

    public companion object {
        public inline operator fun invoke(init: HapiDepartureBoardRequest.() -> Unit): HapiDepartureBoardRequest =
            HapiDepartureBoardRequest().apply(init)
    }
}