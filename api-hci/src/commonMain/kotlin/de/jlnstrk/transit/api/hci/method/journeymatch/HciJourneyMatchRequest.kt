@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.api.hci.method.journeymatch

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.method.linematch.HciLineMatchResult
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import de.jlnstrk.transit.api.hci.request.filter.HciJourneyFilter
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciJourneyMatchRequest(
    public var input: String? = null,
    public var tripId: String? = null,
    public var extId: String? = null,
    public var directions: String? = null,

    public var date: LocalDate? = null,
    public var dateB: LocalDate? = null,
    public var dateE: LocalDate? = null,
    public var time: LocalTime? = null,
    public var timeB: LocalTime? = null,
    public var timeE: LocalTime? = null,

    public var combineMode: CombineMode? = null,
    public var onlyCR: Boolean? = null,
    public var onlyRT: Boolean? = null,
    public var onlyTN: Boolean? = null,
    public var clustering: Boolean? = null,
    public var matchLine: Boolean? = null,
    public var useAeqi: Boolean? = null,
    public var getLineXml: Boolean? = null,

    public var maxJourneys: Int? = null,

    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
) : HciServiceRequest<HciLineMatchResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.JOURNEY_MATCH

    @HciModel("1.39")
    @Serializable
    public enum class CombineMode {
        @SerialName("EXACT-LW")
        EXACT_LW,
        LW,

        @SerialName("LW-TIME")
        LW_TIME,
        NONE,

        @SerialName("VW-LW")
        VW_LW,

        @SerialName("VW-RI")
        VW_RI,
    }

    public companion object {
        public inline operator fun invoke(init: HciJourneyMatchRequest.() -> Unit): HciJourneyMatchRequest =
            HciJourneyMatchRequest().apply(init)
    }
}