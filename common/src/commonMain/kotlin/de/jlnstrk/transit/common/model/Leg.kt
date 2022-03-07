package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.common.model.stop.Stop

public sealed class Leg {
    public abstract val departure: Stop.Departure
    public abstract val arrival: Stop.Arrival

    public data class Public(
        override val departure: Stop.Departure,
        override val arrival: Stop.Arrival,
        val journey: Journey,
        val alternatives: List<Journey>?,
        val frequency: Frequency?
    ) : Leg()

    public data class Transfer(
        override val departure: Stop.Departure,
        override val arrival: Stop.Arrival
    ) : Leg()

    public data class Individual(
        override val departure: Stop.Departure,
        override val arrival: Stop.Arrival,
        val type: Type,
        val gis: GisRoute
    ) : Leg() {

        public enum class Type {
            WALK, BIKE, CAR, TAXI
        }
    }
}