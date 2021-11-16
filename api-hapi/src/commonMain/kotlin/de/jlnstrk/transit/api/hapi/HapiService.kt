package de.jlnstrk.transit.api.hapi

public enum class HapiService(@PublishedApi internal val service: String) {
    LOCATION_NAME("location.name"),
    LOCATION_NEARBYSTOPS("location.nearbystops"),
    ARRIVAL_BOARD("arrivalBoard"),
    DEPARTURE_BOARD("departureBoard"),
    JOURNEY_DETAIL("journeyDetail"),
    TRIP("trip"),
    HIM_SEARCH("himsearch"),
    GIS_ROUTE("gisroute"),
}