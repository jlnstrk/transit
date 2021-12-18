@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.client.hci.method.himsearch

import de.jlnstrk.transit.client.hafas.HafasHimSortOrder
import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import de.jlnstrk.transit.client.hci.model.HciAffiliatedJourneyMode
import de.jlnstrk.transit.client.hci.model.HciAffiliatedJourneyStopMode
import de.jlnstrk.transit.client.hci.model.HciHimMessageResultElementSelector
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.request.HciServiceRequest
import de.jlnstrk.transit.client.hci.request.filter.HciHimFilter
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciHimSearchRequest(
    public var affJnyMode: HciAffiliatedJourneyMode? = null,
    public var affJnyStopMode: HciAffiliatedJourneyStopMode? = null,
    public var allowedTextTags: String? = null,

    public var mode: Mode? = null,
    public var resElemSelect: HciHimMessageResultElementSelector? = null,
    public var testMode: Int? = null,

    /** Filter by beginning date of messages */
    public var dateB: LocalDate? = null,
    /** Filter by ending date of messages */
    public var dateE: LocalDate? = null,
    /** Filter by daily beginning time of messages */
    public var dailyB: LocalTime? = null,
    /** Filter by daily ending time of messages */
    public var dailyE: LocalTime? = null,
    /** Filter by beginning time of messages */
    public var timeB: LocalTime? = null,
    /** Filter by ending time of messages */
    public var timeE: LocalTime? = null,

    // TODO: Meaning? Company?
    public var comp: String? = null,
    // TODO: What are directions in this context?
    public var bothDir: Boolean? = null,
    // TODO: Meaning?
    public var onlyHimId: Boolean? = null,
    // TODO: Meaning?
    public var dept: String? = null,

    /** The associated location of messages to be returned */
    public var stLoc: HciLocation? = null,
    // TODO: Meaning?
    public var dirLoc: HciLocation? = null,

    // TODO: Meaning? Service days? Possibly encoded?
    public var srvDays: String? = null,
    // TODO: Meaning? Possibly encoded?
    public var wDays: String? = null,
    /** Whether parent messages shall be returned */
    public var getParent: Boolean? = null,
    /** Whether child messages shall be returned */
    public var getChildren: Boolean? = null,
    /** Whether associated polylines shall be returned */
    public var getPolyline: Boolean? = null,
    /** Whether only today's messages shall be returned */
    public var onlyToday: Boolean? = null,

    /** The maximum number of messages to be returned */
    public var maxNum: Int? = null,
    /** The maximum priority of messages to be returned */
    public var maxPrio: Int? = null,
    /** The minimum priority of messages to be returned */
    public var minPrio: Int? = null,

    /** Additional him message filters to be taken into account */
    public var himFltrL: List<HciHimFilter> = emptyList(),
    /** Sort order for the returned messages */
    public var sortL: List<HafasHimSortOrder> = emptyList(),
) : HciServiceRequest<HciHimSearchResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.HIM_SEARCH

    @Serializable
    public enum class Mode {
        /** Return messages that match the specified criteria */
        MATCH,

        /** Return messages that don't match the specified criteria */
        NOMATCH,

        // TODO: Meaning?
        TFMATCH,
    }

    public companion object {
        public inline operator fun invoke(init: HciHimSearchRequest.() -> Unit): HciHimSearchRequest =
            HciHimSearchRequest().apply(init)
    }
}