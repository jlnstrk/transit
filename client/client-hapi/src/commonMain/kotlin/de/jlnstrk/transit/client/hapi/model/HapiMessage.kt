@file:UseSerializers(
    HapiLocalDateSerializer::class,
    HapiLocalTimeSerializer::class
)

package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.journey.HapiJourney
import de.jlnstrk.transit.client.hapi.model.stop.HapiStop
import de.jlnstrk.transit.client.hapi.serializer.HapiListUnwrapSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiLocalDateSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HapiXsd("1.29")
@Serializable
public data class HapiMessage(
    public val id: String,
    /** External ID of the message if based on an external system. */
    public val externalId: String?,
    /** If message is active, value is true. */
    public val act: Boolean = true,
    /** Heading of message. */
    public val head: String,
    /** Preamble of message. */
    public val lead: String?,
    /** Message text. */
    public val text: String,
    /** Custom text */
    public val customText: String?,
    /** Deprecated. Message text for ticker display. */
    public val tckr: String?,
    /** Company whom created this message. */
    public val company: String?,
    /** Deprecated. See Message/MessageCategory. For sanity reason, id of first MessageCategory ist filled here. */
    public val category: String?,
    /** Priority of the message. */
    public val priority: Int,
    /** This value specifies the products affected by this message. */
    public val products: Int?,
    public val icon: String?,
    /** First stop/station where this message is valid.
     * See the Stops list in the JourneyDetail response for this leg to get more details about this stop/station. */
    public val routeIdxFrom: Int?,
    /** Last stop/station where this message is valid.
     * See the Stops list in the JourneyDetail response for this leg to get more details about this stop/station. */
    public val routeIdxTo: Int?,
    /** Event period beginning time in format hh:mm[:ss] */
    public val sTime: LocalTime?,
    /** Event period beginning date in format YYYY-MM-DD. */
    public val sDate: LocalDate?,
    /** Event period ending time in format hh:mm[:ss] */
    public val eTime: LocalTime?,
    /** Event period ending date in format YYYY-MM-DD. */
    public val eDate: LocalDate?,
    /** Descriptive text for start of event period. */
    public val altStart: String?,
    /** Descriptive text for end of event period. */
    public val altEnd: String?,
    /** Message was last modified at time in format hh:mm[:ss] */
    public val modTime: LocalTime?,
    /** Message was last modified at date in format YYYY-MM-DD. */
    public val modDate: LocalDate?,
    /** Products affected by this message */
    public val affectedProduct: List<HapiProduct> = emptyList(),
    /** Journeys affected by this message */
    public val affectedJourney: List<HapiJourney> = emptyList(),
    /** Edges affected by this message */
    public val edge: List<Edge> = emptyList(),
    /** Regions affected by this message */
    public val region: List<Region> = emptyList(),
    /** Stops affected by this message */
    public val affectedStops: List<HapiAffectedStop> = emptyList(),
    /** Message is valid from this stop. */
    public val validFromStop: HapiStop?,
    /** Message is valid until this stop. */
    public val validToStop: HapiStop?,
    /** List of tags this message is tagged with. */
    @Serializable(with = HapiListUnwrapSerializer::class)
    public val tags: List<String> = emptyList(),
    /** List of publication channels along with its validity and optional URLs. */
    public val channel: List<Channel> = emptyList(),
    /** List of message categories with its ID and optional localized name. */
    public val messageCategory: List<Category> = emptyList(),
    /** List of messages texts with its tags and localized text fragments. */
    public val messageText: List<Text> = emptyList(),
    /** List of notes to be displayed for this message. */
    public val Note: List<HapiNote> = emptyList(),
    /** Child messages. */
    public val message: List<HapiMessage> = emptyList()
) {

    @Serializable
    public data class Edge(
        /** Polylines describing the route graph */
        public val polyline: List<HapiPolyline> = emptyList(),
        /** Polyline groups describing the route graph */
        public val polylineGroup: List<HapiPolylineGroup> = emptyList(),
        /** Geoposition to draw an icon at */
        public val iconCoordinate: HapiCoord?,
        /** Reference to releated [HaoiMessage.id]s */
        public val messageRef: List<Int> = emptyList(),
        /** Direction on the egde the message is valid for:
         * 0: unknown; 1: in direction of egde; 2: in oposite direction of edge; 3: both directions */
        public val direction: Int = 0,
    )

    @Serializable
    public data class Region(
        /** Polylines describing the region. */
        public val polyline: List<HapiPolyline> = emptyList(),
        /** Polyline groups describing the region. */
        public val polylineGroup: List<HapiPolylineGroup> = emptyList(),
        /** Geoposition to draw an icon at */
        public val iconCoordinate: HapiCoord?,
        /** Reference to releated [HaoiMessage.id]s */
        public val messageRef: List<Int> = emptyList(),
    )

    @Serializable
    public data class Channel(
        /** Name of the channel. */
        public val name: String?,
        /** URL to external content of this message channel. */
        public val url: List<String> = emptyList(),
        /** In this channel, the message is valid beginning at time in format hh:mm[:ss] */
        public val validFromTime: LocalTime,
        /** In this channel, the message is valid beginning at date in format YYYY-MM-DD. */
        public val validFromDate: LocalDate,
        /** In this channel, the message is valid ending at time in format hh:mm[:ss] */
        public val validToTime: LocalTime,
        /** In this channel, the message is valid ending at date in format YYYY-MM-DD. */
        public val validToDate: LocalDate,
    )

    /** Message category having an ID and optional a name. */
    @Serializable
    public data class Category(
        /** ID of the HIM message category */
        public val id: Int,
        /** Localized name of the HIM message category */
        public val name: String?,
    )

    @Serializable
    public data class Text(
        /** List of tags this message text is tagged with. */
        public val tag: List<String>,
        /** List of text fragments. */
        public val text: List<String>
    )
}