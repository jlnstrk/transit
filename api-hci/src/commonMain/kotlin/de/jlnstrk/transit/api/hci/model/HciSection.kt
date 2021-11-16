package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hci.model.gis.HciGis
import de.jlnstrk.transit.api.hci.model.journey.HciJourney
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import de.jlnstrk.transit.api.hci.serializer.time.HciDurationSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
@JsonClassDiscriminator("type")
public sealed class HciSection {
    @SerialName("dep")
    public lateinit var departure: HciStop
        internal set

    @SerialName("arr")
    public lateinit var arrival: HciStop
        internal set

    @SerialName("icoX")
    public var iconIndex: Int? = null
        internal set

    public lateinit var type: Type
        internal set

    @Serializable
    public enum class Type {
        @SerialName("JNY")
        JOURNEY,

        @SerialName("TRSF")
        TRANSFER,

        WALK,

        BIKE,

        KISS,

        TAXI,

        @SerialName("TETA")
        TELE_TAXI,

        @SerialName("PARK")
        PARK_RIDE
    }

    @Serializable
    @SerialName("JNY")
    public class Journey(
        public val jny: HciJourney,

        @Serializable(with = HciDurationSerializer::class)
        public val minChg: Duration?,

        public val msgL: List<HciMessage> = emptyList(),
    ) : HciSection()

    @Serializable
    @SerialName("WALK")
    public class Walk(
        public val gis: HciGis,
        public val hide: Boolean?
    ) : HciSection()

    @Serializable
    @SerialName("TRSF")
    public class Transfer : HciSection()

    @Serializable
    @SerialName("BIKE")
    public class Bike(
        public val gis: HciGis
    ) : HciSection()

    @Serializable
    @SerialName("KISS")
    public class Kiss(
        public val gis: HciGis
    ) : HciSection()

    @Serializable
    @SerialName("TAXI")
    public class Taxi(
        public val gis: HciGis
    ) : HciSection()

    @Serializable
    @SerialName("PARK")
    public class ParkAndRide(
        public val gis: HciGis
    ) : HciSection()

    @Serializable
    @SerialName("TETA")
    public class TeleTaxi(
        public val gis: HciGis
    ) : HciSection()
}