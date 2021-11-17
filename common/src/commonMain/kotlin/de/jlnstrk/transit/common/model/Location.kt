package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.common.model.base.Identifiable

public sealed interface Location : Identifiable {
    public val type: Type
    public var name: String?
    public var place: String?
    public var coordinates: Coordinates?
    override val literalId: String?
    override val numericId: Long

    public data class Place(
        override var name: String? = null,
        override var place: String? = null,
        override var coordinates: Coordinates? = null,
        override var literalId: String? = null,
        override var numericId: Long = -1L
    ) : Location {
        override val type: Type get() = Type.PLACE
    }

    public data class Point(
        override var coordinates: Coordinates? = null
    ) : Location {
        override val type: Type get() = Type.POINT
        override var name: String? = null
        override var place: String? = null
        override val literalId: String? get() = null
        override val numericId: Long get() = -1L
    }

    public data class Address(
        override var name: String? = null,
        override var place: String? = null,
        override var coordinates: Coordinates? = null,
        override var literalId: String? = null,
        override var numericId: Long = -1L,
        var street: String? = null,
        var buildingNumber: String? = null
    ) : Location {
        override val type: Type get() = Type.ADDRESS
    }

    public data class Poi(
        override var name: String? = null,
        override var place: String? = null,
        override var coordinates: Coordinates? = null,
        override val literalId: String? = null,
        override val numericId: Long = -1L,
        var subject: String? = null
    ) : Location {
        override val type: Type get() = Type.POI
    }

    public data class Station(
        override var name: String? = null,
        override var place: String? = null,
        override var coordinates: Coordinates? = null,
        override val literalId: String? = null,
        override val numericId: Long = -1L,
        var products: ProductSet? = null,
        var lines: LineSet? = null,
        var weight: Int? = null,
        var isSubStation: Boolean = false
    ) : Location, Comparable<Station> {
        override val type: Type get() = Type.STATION

        override fun compareTo(other: Station): Int {
            return other.weight?.let { weight?.compareTo(it) } ?: 0
        }
    }

    public enum class Type {
        STATION,
        ADDRESS,
        POI,
        PLACE,
        POINT
    }
}