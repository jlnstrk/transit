package de.jlnstrk.transit.common.model

public enum class TransportMode : ProductClass {
    TRAIN,
    SUBWAY,
    LIGHT_RAIL,
    CABLE,
    BUS,
    CAR,
    WATERCRAFT,
    OTHER;

    override val mode: TransportMode get() = this
}