@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.model

import de.jlnstrk.transit.api.efa.serializer.EfaStringSpaceConcatSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaMinutesSerializer
import de.jlnstrk.transit.api.efa.serializer.generic.EfaOptionalListSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaLeg(
    /** The duration of this leg */
    @Serializable(with = EfaMinutesSerializer::class)
    public val timeMinute: Duration,

    /** The realtime status information for this leg */
    public val realtimeStatus: EfaJourney.RealtimeStatus?,

    /** The departure and arrival stops of this leg */
    public val points: List<EfaStop>,

    /** The mode of this journey */
    public val mode: EfaMode,

    /** The hints associated with this leg */
    @Serializable(with = EfaOptionalListSerializer::class)
    public val hints: List<EfaHint> = emptyList(),

    /** The sequence of intermediate stops on this leg */
    @SerialName("stopSeq")
    public val stopSequence: List<EfaStop> = emptyList(),

    // TODO: Purpose?
    public val format: String?,

    /** The coordinate polyline of this leg */
    @Serializable(with = EfaStringSpaceConcatSerializer::class)
    public val path: List<@Contextual EfaCoordinates> = emptyList()

    // TODO: attrs
)