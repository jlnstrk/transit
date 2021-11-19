@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.model

import de.jlnstrk.transit.api.efa.serializer.generic.EfaOptionalListSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaMinutesSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

/**
 * Describes the json structure encoding trips from the XML_TRIP_REQUEST2 endpoint.
 * Appears at `$.trips[]`
 */
@Serializable
public data class EfaTrip(
    /** The distance covered by this trip */
    public val distance: Int,

    /** The duration of this trip */
    @Serializable(with = EfaMinutesSerializer::class)
    public val duration: Duration,

    /** The number of changes on this trip */
    public val interchange: Int,

    /** TODO: Purpose? */
    public val desc: Boolean,

    /** TODO: Purpose? */
    public val optValue: Int?,

    /** The legs of this trip */
    public val legs: List<EfaLeg>,

    /** The fare information relevant to this trip */
    public val itdFare: Fare
) {

    /**
     * Describes the json structure encoding trip fare information.
     * Appears at $.trips[].itdFare
     */
    @Serializable
    public data class Fare(
        /** The fares associated with this trip */
        @Serializable(with = EfaOptionalListSerializer::class)
        public val fares: List<EfaFare>?,

        /** The tickets associated with this trip */
        @Serializable(with = EfaOptionalListSerializer::class)
        public val tickets: List<EfaTicket>?,

        /** The tariff zones used by this trip */
        @Serializable(with = EfaOptionalListSerializer::class)
        public val tariffZones: List<EfaTariffZone>?,

        /** The special tickets associated with this trip */
        @Serializable(with = EfaOptionalListSerializer::class)
        public val specialTickets: List<EfaTicket>?
    )
}