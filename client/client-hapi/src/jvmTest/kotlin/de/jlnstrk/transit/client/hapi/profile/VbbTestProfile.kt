package de.jlnstrk.transit.client.hapi.profile

import de.jlnstrk.transit.client.hapi.*
import de.jlnstrk.transit.client.hapi.base.HapiTestProfile

internal val VBB = HapiTestProfile("VBB") {
    config = HapiConfig {
        baseUrl = "https://demo.hafas.de/openapi/vbb-proxy/"
        accessId = BuildKonfig.VBB_AID!!

        enabledServices = setOf(
            HapiEndpoint.LOCATION_NAME,
            HapiEndpoint.LOCATION_NEARBYSTOPS,
            HapiEndpoint.ARRIVAL_BOARD,
            HapiEndpoint.DEPARTURE_BOARD,
            HapiEndpoint.JOURNEY_DETAIL,
            HapiEndpoint.TRIP,
            HapiEndpoint.HIM_SEARCH,
            HapiEndpoint.GIS_ROUTE
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