package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.common.model.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class Location {
    public abstract val id: String?
    public abstract val name: String?
    public abstract val place: String?
    public abstract val coordinates: Coordinates?

    @Serializable
    @SerialName("REFERENCE")
    public data class Reference(
        public override val id: String? = null,
        public override val name: String? = null,
        public override val place: String? = null,
    ) : Location() {
        override val coordinates: Coordinates? get() = null
    }

    @Serializable
    @SerialName("PLACE")
    public data class Place(
        override val id: String,
        override val name: String,
        override val place: String? = null,
        override val coordinates: Coordinates,
    ) : Location(), Identifiable

    @Serializable
    @SerialName("POINT")
    public data class Point(
        override val coordinates: Coordinates
    ) : Location(), Identifiable {
        override val name: String? get() = null
        override val place: String? get() = null
        override val id: String get() = "${coordinates.latitude}:${coordinates.longitude}"
    }

    @Serializable
    @SerialName("ADDRESS")
    public data class Address(
        override val id: String,
        override val name: String,
        override val place: String? = null,
        override val coordinates: Coordinates,
        public val street: String? = null,
        public val buildingNumber: String? = null
    ) : Location(), Identifiable

    @Serializable
    @SerialName("POI")
    public data class Poi(
        override val id: String,
        override val name: String,
        override val place: String? = null,
        override val coordinates: Coordinates,
        public val subject: String? = null
    ) : Location(), Identifiable

    @SerialName("STATION")
    public data class Station(
        override val id: String,
        override val name: String,
        override val place: String? = null,
        override val coordinates: Coordinates,
        public val products: ProductSet? = null,
        public val lines: LineSet? = null,
        public val weight: Int? = null,
        public val isSubStation: Boolean = false
    ) : Location(), Identifiable, Comparable<Station> {

        override fun compareTo(other: Station): Int {
            return other.weight?.let { weight?.compareTo(it) } ?: 0
        }
    }

    @Serializable
    public enum class Type {
        REFERENCE,
        STATION,
        ADDRESS,
        POI,
        PLACE,
        POINT
    }
}