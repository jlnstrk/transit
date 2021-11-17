package de.jlnstrk.transit.api.hapi.request

import de.jlnstrk.transit.api.hapi.HapiEndpoint
import de.jlnstrk.transit.api.hapi.response.HapiArrivalBoard

public class HapiArrivalBoardRequest : HapiStationBoardRequest<HapiArrivalBoard>() {
    override val service: HapiEndpoint get() = HapiEndpoint.ARRIVAL_BOARD

    public companion object {
        public inline operator fun invoke(init: HapiArrivalBoardRequest.() -> Unit): HapiArrivalBoardRequest =
            HapiArrivalBoardRequest().apply(init)
    }
}