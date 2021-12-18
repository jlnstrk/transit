@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.response

import de.jlnstrk.transit.client.efa.model.EfaPoint
import de.jlnstrk.transit.client.efa.serializer.EfaInputUnwrapSerializer
import de.jlnstrk.transit.client.efa.serializer.generic.EfaOptionalListSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.datetime.EfaMinutesSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public class EfaPointVerification(
    public val message: EfaMessage?,
    @Serializable(with = EfaInputUnwrapSerializer::class)
    public val input: String?,
    @Serializable(with = EfaOptionalListSerializer::class)
    public val points: List<EfaPoint> = emptyList(),
    @Serializable(with = EfaOptionalListSerializer::class)
    public val itdOdvAssignedStops: List<AssignedStop> = emptyList(),
) {

    @Serializable
    public data class AssignedStop(
        public val stopID: Int,
        public val name: String,
        public val y: String,
        public val x: String,
        public val mapName: String,
        public val value: String,
        public val place: String,
        public val nameWithPlace: String,
        public val distance: Int?,
        @Serializable(with = EfaMinutesSerializer::class)
        public val distanceTime: Duration,
        public val isTransferStop: Boolean,
        public val hasStaticInfo: Boolean = false,
        public val vm: String,
        public val gid: String,
    )

    @Serializable
    public enum class Usage {
        @SerialName("sf")
        STOP_FINDER,

        @SerialName("dm")
        DEPARTURE_MONITOR,

        @SerialName("origin")
        ORIGIN,

        @SerialName("via")
        VIA,

        @SerialName("destination")
        DESTINATION,

        @SerialName("stt")
        STOP_TIMETABLE,
    }

    @Serializable
    public enum class Type {
        @SerialName("any")
        ANY,

        @SerialName("coord")
        COORD,

        @SerialName("stop")
        STOP,

        @SerialName("poi")
        POI,
    }
}