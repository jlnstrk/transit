package de.jlnstrk.transit.common.model

public enum class Means : ProductClass {
    TRAIN,
    SUBWAY,
    LIGHT_RAIL,
    CABLE,
    BUS,
    CAR,
    WATERCRAFT,
    OTHER;

    override val base: Means get() = this
}