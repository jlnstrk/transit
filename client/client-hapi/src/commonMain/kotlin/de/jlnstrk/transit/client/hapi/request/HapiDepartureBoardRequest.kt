package de.jlnstrk.transit.client.hapi.request

import de.jlnstrk.transit.client.hapi.HapiEndpoint
import de.jlnstrk.transit.client.hapi.response.HapiDepartureBoard

public class HapiDepartureBoardRequest : HapiStationBoardRequest<HapiDepartureBoard>() {
    override val service: HapiEndpoint get() = HapiEndpoint.DEPARTURE_BOARD

    public companion object {
        public inline operator fun invoke(init: HapiDepartureBoardRequest.() -> Unit): HapiDepartureBoardRequest =
            HapiDepartureBoardRequest().apply(init)
    }
}