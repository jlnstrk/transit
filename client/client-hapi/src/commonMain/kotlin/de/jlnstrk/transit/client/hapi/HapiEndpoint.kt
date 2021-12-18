package de.jlnstrk.transit.client.hapi

public enum class HapiEndpoint(
    @PublishedApi internal val endpoint: String
) {
    LOCATION_NAME("location.name"),
    LOCATION_NEARBYSTOPS("location.nearbystops"),
    ARRIVAL_BOARD("arrivalBoard"),
    DEPARTURE_BOARD("departureBoard"),
    JOURNEY_DETAIL("journeyDetail"),
    TRIP("trip"),
    HIM_SEARCH("himsearch"),
    GIS_ROUTE("gisroute"),
}