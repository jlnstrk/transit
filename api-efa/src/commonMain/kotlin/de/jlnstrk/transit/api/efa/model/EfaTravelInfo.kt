@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.model

import de.jlnstrk.transit.api.efa.serializer.generic.EfaOptionalListSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaNestedObjectDateTimeSerializer
import de.jlnstrk.transit.util.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

/**
 * Describes the json structure encoding travel infos from the XML_ADDINFO_REQUEST endpoint.
 * Appears at `$.additionalInformation.travelInfos[].travelInformation[]`
 */
@Serializable
public data class EfaTravelInfo(
    /** TODO: Purpose */
    public val file: String?,

    /** The type of this info */
    public val type: Type,

    /** The code of this info's provider */
    public val providerCode: String,

    /** The info's id */
    public val infoID: String,

    /** The links associated with this info */
    @Serializable(with = EfaOptionalListSerializer::class)
    public val infoLink: List<Info>,

    /** The sequence id of this info */
    public val seqID: Int? = null,

    /** Whether this info has been deactivated */
    public val deactivated: Boolean,

    /** The priority of this info */
    public val priority: Priority,

    /** Whether this info is currently public */
    public val publish: Boolean,

    /** Whether this info is valid */
    public val valid: Boolean,

    /** The system that produced this info */
    public val sourceSystem: EfaSystem,

    /** The time of date/time of creation of this info */
    @Serializable(with = EfaNestedObjectDateTimeSerializer::class)
    public val creationTime: LocalDateTime,

    /** The period that this info is public in */
    public val publicationDuration: EfaPeriod,

    /** The period that this info is valid in */
    public val validityPeriod: List<EfaPeriod>,

    /** The date/time of when this info expires */
    @Serializable(with = EfaNestedObjectDateTimeSerializer::class)
    public val expirationDateTime: LocalDateTime,

    /** The lines affected by this info */
    public val concernedLines: List<EfaLine>?
) {

    @Serializable
    public enum class Type {
        @SerialName("lineInfo")
        LINE_INFO,

        @SerialName("lineBlocking")
        LINE_BLOCKING,

        @SerialName("stopInfo")
        STOP_INFO,

        @SerialName("stopBlocking")
        STOP_BLOCKING,

        @SerialName("routeInfo")
        ROUTE_INFO,

        @SerialName("routeBlocking")
        ROUTE_BLOCKING,

        @SerialName("areaInfo")
        AREA_INFO,

        @SerialName("bannerInfo")
        BANNER_INFO,

        @SerialName("generalInfo")
        GENERAL_INFO,

        @SerialName("tripMessage")
        TRIP_MESSAGE,

        @SerialName("trafficSituation")
        TRAFFIC_SITUATION,
    }

    @Serializable
    public enum class Priority {
        @SerialName("low")
        VERY_LOW,

        @SerialName("low")
        LOW,

        @SerialName("normal")
        NORMAL,

        @SerialName("high")
        HIGH,

        @SerialName("veryHigh")
        VERY_HIGH,

        // What the hell? This actually occurs
        @SerialName("3")
        THREE
    }

    @Serializable
    public data class Info(
        public val language: String,
        public val paramList: List<Param>,
        public val infoLinkText: String?,
        public val infoLinkURL: String,
        public val content: String?,
        public val subtitle: String?,
        public val additionalLinks: List<Link>? = null
    ) {

        @Serializable
        public data class Param(
            public val type: Type,
            public val name: String,
            public val value: String,
            public val edit: Boolean
        ) {

            @Serializable
            public enum class Type {
                @SerialName("system")
                SYSTEM,

                @SerialName("addInfoParam")
                ADD_INFO
            }
        }

        @Serializable
        public data class Link(
            public val ID: Int?,
            public val linkURL: String?,
            public val linkText: String?,
            public val linkTextShort: String?,
            public val linkTarget: String?
        )
    }

    public data class Line(
        public val selected: String? = null,
        public val number: String? = null,
        public val name: String? = null,
        public val supplement: String? = null,
        public val direction: String? = null,
        public val directionName: String? = null,
        public val partialNet: String? = null,
        public val motType: EfaMeansOfTransport? = null,
        public val motCode: Int = -1,
        public val productId: String? = null,
        public val operator: String? = null,
        public val admin: String? = null,
        public val stateless: String? = null,
        public val directionFrom: String? = null,
    )
}