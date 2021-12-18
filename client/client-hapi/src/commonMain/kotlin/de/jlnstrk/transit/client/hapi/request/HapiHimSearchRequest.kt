package de.jlnstrk.transit.client.hapi.request

import de.jlnstrk.transit.client.hafas.HafasHimSortOrder
import de.jlnstrk.transit.client.hafas.HafasPolylineEncoding
import de.jlnstrk.transit.client.hapi.HapiEndpoint
import de.jlnstrk.transit.client.hapi.request.delegate.*
import de.jlnstrk.transit.client.hapi.request.delegate.HapiBooleanParam
import de.jlnstrk.transit.client.hapi.request.delegate.HapiLocalDateParam
import de.jlnstrk.transit.client.hapi.request.delegate.HapiLocalTimeParam
import de.jlnstrk.transit.client.hapi.request.delegate.HapiQueryParam
import de.jlnstrk.transit.client.hapi.request.delegate.HapiStringListParam
import de.jlnstrk.transit.client.hapi.response.HapiHimMessages
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlin.jvm.JvmInline

public class HapiHimSearchRequest : HapiRequest<HapiHimMessages>() {
    override val service: HapiEndpoint get() = HapiEndpoint.HIM_SEARCH

    /** Sets the event period start date */
    public var dateB: LocalDate? by HapiLocalDateParam

    /** Sets the event period end date */
    public var dateE: LocalDate? by HapiLocalDateParam

    /** Sets the event period start time */
    public var timeB: LocalTime? by HapiLocalTimeParam

    /** Sets the event period end time */
    public var timeE: LocalTime? by HapiLocalTimeParam

    /** Bitmask for validity of HIM messages based on weekdays.
     * Each character represents a weekday starting on monday */
    public var weekdays: WeekMask? by HapiQueryParam(
        serialize = { it.underlying.toString(2) },
        deserialize = { WeekMask(it.toInt(2)) }
    )

    /** List of HIM message IDs seperated by comma */
    public var himIds: List<String>? by HapiStringListParam

    /** Return parent messages with childs */
    public var hierarchicalView: Boolean? by HapiBooleanParam

    /** List of operators seperated by comma */
    public var operators: List<String>? by HapiStringListParam

    /** List of train categories seperated by comma */
    public var categories: List<String>? by HapiStringListParam

    /** List of channels seperated by comma */
    public var channels: List<String>? by HapiStringListParam

    /** List of companies seperated by comma */
    public var companies: List<String>? by HapiStringListParam

    /** Only HIM messages for the given line are part of the result.
     * To filter multiple lines, separate the codes by comma */
    public var lines: List<String>? by HapiStringListParam

    /** Only HIM messages for the given line (identified by its line ID) are part of the result.
     * To filter multiple lines, separate the line IDs by comma */
    public var lineids: List<String>? by HapiStringListParam

    /** List of (external) station ids to be filtered for seperated by comma */
    public var stations: List<String>? by HapiStringListParam

    /** Filter messages by line segment starting at this station given as (external) station id */
    public var fromstation: String? by HapiStringParam

    /** Filter messages by line segment travelling in direction of this station given as (external) station id */
    public var tostation: String? by HapiStringParam

    /** If enabled, messages in both directions - from 'himfromstation' to 'himtostation'
     * as well as from 'himtostation' to 'himfromstation' are returned */
    public var bothways: Boolean? by HapiBooleanParam

    /** List of train name to be filtered for seperated by comma */
    public var trainnames: List<String>? by HapiStringListParam

    /** List of predefined filters seperated by comma */
    public var metas: List<String>? by HapiStringListParam

    /** HIM category, e.g. Works and/or Disturbance. Value depends on your HAFAS server data */
    public var himcategory: String? by HapiStringParam

    /** HIM Tags. Value depends on your HAFAS server data */
    public var himtags: List<String>? by HapiStringListParam

    /** Filter for Him messages containing the given free text message seperated by comma */
    public var himtext: String? by HapiStringParam

    /** Enables/disables returning of geo information for affected edges and regions
     * if available and enabled in the backend */
    public var poly: Boolean? by HapiBooleanParam

    /** Polyline encoding format */
    public var polyEnc: HafasPolylineEncoding? by HapiEnumParam()

    /** HIM search mode */
    public var searchmode: String? by HapiStringParam

    /** Define how to return affected journeys */
    public var affectedJourneyMode: String? by HapiStringParam

    /** Define how to return stops of affected journeys */
    public var affectedJourneyStopMode: String? by HapiStringParam

    /** Define the Order the returned messages by fields and directions.
     * Multiple, comma separated entries are supported */
    public var orderBy: List<HafasHimSortOrder>? by HapiEnumParam.List()

    /** Filter for HIM messages having at least this priority */
    public var minprio: Int? by HapiIntParam

    /** Filter for HIM messages having this priority as maximum */
    public var maxprio: Int? by HapiIntParam

    public companion object {
        public inline operator fun invoke(init: HapiHimSearchRequest.() -> Unit): HapiHimSearchRequest =
            HapiHimSearchRequest().apply(init)
    }

    @JvmInline
    public value class WeekMask(
        internal val underlying: Int
    ) {
        public val monday: Boolean get() = (underlying and 0b1000000) != 0
        public val tuesday: Boolean get() = (underlying and 0b100000) != 0
        public val wednesday: Boolean get() = (underlying and 0b10000) != 0
        public val thursday: Boolean get() = (underlying and 0b1000) != 0
        public val friday: Boolean get() = (underlying and 0b100) != 0
        public val saturday: Boolean get() = (underlying and 0b10) != 0
        public val sunday: Boolean get() = (underlying and 0b1) != 0

        public constructor(
            monday: Boolean,
            tuesday: Boolean,
            wednesday: Boolean,
            thursday: Boolean,
            friday: Boolean,
            saturday: Boolean,
            sunday: Boolean,
        ) : this(
            (monday.compareTo(false) shl 6)
                    or (tuesday.compareTo(false) shl 5)
                    or (wednesday.compareTo(false) shl 4)
                    or (thursday.compareTo(false) shl 3)
                    or (friday.compareTo(false) shl 2)
                    or (saturday.compareTo(false) shl 1)
                    or sunday.compareTo(false)
        )
    }
}