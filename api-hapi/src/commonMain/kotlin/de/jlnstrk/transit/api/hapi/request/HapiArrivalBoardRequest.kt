package de.jlnstrk.transit.api.hapi.request

import de.jlnstrk.transit.api.hapi.HapiService
import de.jlnstrk.transit.api.hapi.response.HapiArrivalBoard

public class HapiArrivalBoardRequest : HapiStationBoardRequest<HapiArrivalBoard>() {
    override val service: HapiService get() = HapiService.ARRIVAL_BOARD

    public companion object {
        public inline operator fun invoke(init: HapiArrivalBoardRequest.() -> Unit): HapiArrivalBoardRequest =
            HapiArrivalBoardRequest().apply(init)
    }
}