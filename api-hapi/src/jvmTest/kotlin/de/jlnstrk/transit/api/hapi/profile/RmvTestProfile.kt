package de.jlnstrk.transit.api.hapi.profile

import de.jlnstrk.transit.api.hapi.*
import de.jlnstrk.transit.api.hapi.base.HapiTestProfile

internal val RMV = HapiTestProfile("RMV") {
    config = HapiConfig {
        baseUrl = "https://www.rmv.de/hapi/"
        accessId = BuildKonfig.RMV_AID!!

        enabledServices = setOf(
            HapiService.LOCATION_NAME,
            HapiService.LOCATION_NEARBYSTOPS,
            HapiService.ARRIVAL_BOARD,
            HapiService.DEPARTURE_BOARD,
            HapiService.JOURNEY_DETAIL,
            HapiService.TRIP,
            HapiService.HIM_SEARCH
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