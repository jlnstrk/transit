package de.jlnstrk.transit.common.model

public data class Polyline(
    public val coordinates: List<Coordinates>,
    public val markers: List<Marker>? = null
) {

    public data class Marker(
        val index: Int,
        val location: Location
    )
}