package de.jlnstrk.transit.api.hapi.profile

import de.jlnstrk.transit.api.hapi.*
import de.jlnstrk.transit.api.hapi.base.HapiTestProfile

internal val VBB = HapiTestProfile("VBB") {
    config = HapiConfig {
        baseUrl = "https://demo.hafas.de/openapi/vbb-proxy/"
        accessId = BuildKonfig.VBB_AID!!

        enabledServices = setOf(
            HapiService.LOCATION_NAME,
            HapiService.LOCATION_NEARBYSTOPS,
            HapiService.ARRIVAL_BOARD,
            HapiService.DEPARTURE_BOARD,
            HapiService.JOURNEY_DETAIL,
            HapiService.TRIP,
            HapiService.HIM_SEARCH,
            HapiService.GIS_ROUTE
        )
    }

    testData(
        HapiLocationNameTest.DataSet.FindByName(
            input = "Wedding",
            findExtId = "900009104",
            findNameContains = "S+U Wedding"
        ),
        HapiLocationNearbyStopsTest.DataSet.FindNearby(
            originLat = 52.542732,
            originLong = 13.366061,
            findExtId = "900009104",
            findNameContains = "S+U Wedding",
        ),
        HapiTripTest.DataSet.FindTripById(
            // S+U Wedding
            originExtId = "900009104",
            // S Ostabhnhof
            destExtId = "300188003"
        )
    )
}