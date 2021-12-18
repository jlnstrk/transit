package de.jlnstrk.transit.client.hapi.profile

import de.jlnstrk.transit.client.hapi.*
import de.jlnstrk.transit.client.hapi.base.HapiTestProfile

internal val RMV = HapiTestProfile("RMV") {
    config = HapiConfig {
        baseUrl = "https://www.rmv.de/hapi/"
        accessId = BuildKonfig.RMV_AID!!

        enabledServices = setOf(
            HapiEndpoint.LOCATION_NAME,
            HapiEndpoint.LOCATION_NEARBYSTOPS,
            HapiEndpoint.ARRIVAL_BOARD,
            HapiEndpoint.DEPARTURE_BOARD,
            HapiEndpoint.JOURNEY_DETAIL,
            HapiEndpoint.TRIP,
            HapiEndpoint.HIM_SEARCH
        )
    }

    testData(
        HapiLocationNameTest.DataSet.FindByName(
            input = "Heerstraße",
            findExtId = "3001229",
            findNameContains = "Frankfurt (Main) Heerstraße"
        ),
        HapiLocationNearbyStopsTest.DataSet.FindNearby(
            originLat = 50.144356,
            originLong = 8.607486,
            findExtId = "3001229",
            findNameContains = "Frankfurt (Main) Heerstraße"
        ),
        HapiTripTest.DataSet.FindTripById(
            // Heerstraße
            originExtId = "3001229",
            // Merianplatz
            destExtId = "3000512"
        )
    )
}