@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class,
    HciMinutesSerializer::class
)

package de.jlnstrk.transit.api.hci.method.stationboard

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import de.jlnstrk.transit.api.hci.request.filter.HciJourneyFilter
import de.jlnstrk.transit.api.hci.request.filter.HciLocationFilter
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciMinutesSerializer
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciStationBoardRequest(
    public var type: Type? = null,
    public var stbFltrEquiv: Boolean? = null,

    /** The location to get the station board of */
    public var stbLoc: HciLocation? = null,
    /** Filter journeys that travel in this location's direction */
    public var dirLoc: HciLocation? = null,
    /** Filter journeys of this id */
    public var jid: String? = null,
    // TODO: Usage?
    public var qrCode: String? = null,

    /** The date of the station board */
    public var date: LocalDate? = null,
    // TODO: Usage?
    public var dateB: LocalDate? = null,
    // TODO: Usage?
    public var dateE: LocalDate? = null,

    /** The time of the station board */
    public var time: LocalTime? = null,
    // TODO: Usage?
    public var aTimeS: LocalDate? = null,
    // TODO: Usage?
    public var dTimeS: LocalDate? = null,

    /** The duration of the station board timeframe */
    public var dur: Duration? = null,
    // TODO: Purpose?
    public var minDur: Duration? = null,

    /** Whether to return journeys' passed stops */
    public var getPasslist: Boolean? = null,
    /** The mode for returned journey passlists */
    public var pslMode: PasslistMode? = null,
    /** The maximum number of passed stops to return for a given journey */
    public var pslMaxStops: Int? = null,

    // TODO: Purpose?
    public var per: Boolean? = null,
    // TODO: Purpose?
    public var getJnySameTime: Boolean? = null,
    /** Whether to return simple train compositions */
    public var getSimpleTrainComposition: Boolean? = null,
    /** Whether to return full train compositions */
    public var getTrainComposition: Boolean? = null,

    /** The grouping mode for returned journeys */
    public var grpMode: GroupMode? = null,
    /** The sort order for returned journeys */
    public var sort: SortType? = null,
    /** The maximum number of journeys to return */
    public var maxJny: Int? = null,
    /** Additional filters for the returned journeys */
    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
    /** Additional filters for the journey associated locations */
    public var locFltrL: List<HciLocationFilter> = emptyList(),
) : HciServiceRequest<HciStationBoardResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.STATION_BOARD

    public companion object {
        public inline operator fun invoke(
            init: HciStationBoardRequest.() -> Unit
        ): HciStationBoardRequest =
            HciStationBoardRequest().apply(init)
    }

    @HciModel("1.39")
    @Serializable
    public enum class GroupMode {
        NONE,
        PLTF,
        PROD,
        STOP,
        TIME,
    }

    @HciModel("1.39")
    @Serializable
    public enum class SortType {
        EVAID,
        PT,
        RT,
    }

    @HciModel("1.39")
    @Serializable
    public enum class Type {
        ARR,
        ARR_EQUIVS,
        ARR_MAST,
        ARR_STATION,
        DEP,
        DEP_EQUIVS,
        DEP_MAST,
        DEP_STATION,
    }

    @HciModel("1.39")
    @Serializable
    public enum class PasslistMode {
        ALL,
        IMP,
        OFF,
    }
}