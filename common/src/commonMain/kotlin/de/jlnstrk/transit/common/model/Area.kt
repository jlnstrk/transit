package de.jlnstrk.transit.common.model

public sealed class Area {
    public data class Rectangle(
        public val southwest: Coordinates,
        public val northeast: Coordinates,
    ): Area()

    public data class Radius(
        public val center: Coordinates,
        public val radius: Int,
    ) : Area()
}