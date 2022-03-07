package de.jlnstrk.transit.common.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class Area {
    @Serializable
    @SerialName("RECTANGLE")
    public data class Rectangle(
        public val southwest: Coordinates,
        public val northeast: Coordinates,
    ): Area()

    @Serializable
    @SerialName("RADIUS")
    public data class Radius(
        public val center: Coordinates,
        public val radius: Int,
    ) : Area()
}