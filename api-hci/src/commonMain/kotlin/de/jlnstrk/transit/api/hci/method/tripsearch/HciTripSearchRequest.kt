@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class,
    HciDurationSerializer::class
)

package de.jlnstrk.transit.api.hci.method.tripsearch

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.model.HciRoutingPreselection
import de.jlnstrk.transit.api.hci.model.eco.HciEcoParams
import de.jlnstrk.transit.api.hci.model.gis.HciGisLocation
import de.jlnstrk.transit.api.hci.model.gis.HciGisPreferredLocation
import de.jlnstrk.transit.api.hci.model.recon.HciReconstruction
import de.jlnstrk.transit.api.hci.model.tariff.HciTariffRequest
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import de.jlnstrk.transit.api.hci.request.filter.HciGisFilter
import de.jlnstrk.transit.api.hci.request.filter.HciJourneyFilter
import de.jlnstrk.transit.api.hci.serializer.time.HciDurationSerializer
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
public class HciTripSearchRequest(
    /** The possible departure locations for trips */
    public var depLocL: List<HciLocation> = emptyList(),
    /** The possible arrival locations for trips */
    public var arrLocL: List<HciLocation> = emptyList(),
    /** The via locations for trips to be routed over */
    public var viaLocL: List<Via> = emptyList(),
    /** The anti via locations for trips to avoid */
    public var antiViaLocL: List<Via> = emptyList(),
    // TODO: Purpose?
    public var prefLocL: List<HciLocation> = emptyList(),

    /** The number of trips to be returned that run before the specified datetime */
    public var numB: Int? = null,
    /** The number of trips to be returned that run after the specified datetime */
    public var numF: Int? = null,

    /** A trip request context to scroll upon */
    public var ctxScr: String? = null,

    /** The date of the outgoing connection */
    public var outDate: LocalDate? = null,
    /** The time of the outgoing connection */
    public var outTime: LocalTime? = null,
    /** Whether [outTime] refers to the departure time (as opposed to arrival time) */
    public var outFrwd: Boolean? = null,
    // TODO: Purpose?
    public var outPeriod: Int? = null,
    /** Reconstructions for the outgoing connections */
    public var outReconL: List<String> = emptyList(),

    /** The date of the returning connection */
    public var retDate: LocalDate? = null,
    /** The time of the returning connection */
    public var retTime: LocalTime? = null,
    /** Whether [retTime] refers to the respective departure time (as opposed to arrival time) */
    public var retFrwd: Boolean? = null,
    // TODO: Purpose?
    public var retPeriod: Int? = null,
    /** Reconstructions for the returning connections */
    public var retReconL: List<HciReconstruction> = emptyList(),

    // TODO: Purpose?
    public var period: Duration? = null,
    // TODO: Purpose?
    public var periodCombineDep: Boolean? = null,
    // TODO: Purpose?
    public var periodMaxCons: Int? = null,

    /** The minimum duration for changes */
    public var minChgTime: Duration? = null,
    /** The maximum duration for changes */
    public var maxChgTime: Duration? = null,
    // TODO: Purpose?
    public var supplChgTime: Int? = null,
    // TODO: Purpose?
    public var extChgTime: Duration? = null,
    /** The maximum number of changes */
    public var maxChg: Int? = null,

    // TODO: Purpose?
    public var getLastPass: Boolean? = null,
    /** Whether traffic messages shall be returned */
    public var getTrafficMsg: Boolean? = null,
    /** Whether simple train compositions shall be returned */
    public var getSimpleTrainComposition: Boolean? = null,
    /** Whether full train compositions shall be returned */
    public var getTrainComposition: Boolean? = null,
    // TODO: Purpose?
    public var getAltCoordinates: Boolean? = null,
    // TODO: Purpose?
    public var getAnnotations: Boolean? = null,
    /** Whether connections shall be put in scoring groups */
    public var getConGroups: Boolean? = null,
    // TODO: Purpose?
    public var getIST: Boolean? = null,
    /** Whether individual transport shall be returned */
    public var getIV: Boolean? = null,
    /** Whether public transport options should be considered fro trips */
    public var getPT: Boolean? = null,
    /** Whether passed stops shall be returned */
    public var getPasslist: Boolean? = null,

    /** Whether tariff data shall be returned */
    public var getTariff: Boolean? = null,
    /** Tariff request to specify ticket interest */
    public var trfReq: HciTariffRequest? = null,

    /** Whether route polylines shall be returned */
    public var getPolyline: Boolean? = null,
    // TODO: Purpose?
    public var polySplitting: Boolean? = null,

    /** Whether eco information shall be returned */
    public var getEco: Boolean? = null,
    // TODO: Purpose?
    public var getEcoCmp: Boolean? = null,
    /** The params for eco considerations */
    public var ecoParams: HciEcoParams? = null,

    // TODO: Purpose?
    public var backPreselectionL: List<HciRoutingPreselection> = emptyList(),
    // TODO: Purpose?
    public var frontPreselectionL: List<HciRoutingPreselection> = emptyList(),
    // TODO: Purpose?
    public var baim: Boolean? = null,
    // TODO: Purpose?
    public var disableDurOpt: Boolean? = null,
    // TODO: Purpose?
    public var freq: Int? = null,
    /** Whether trips should be computed based on economic criteria */
    public var economic: Boolean? = null,
    /** Whether stops nearby the specified departure and arrival locations can be considered */
    public var ushrp: Boolean? = null,
    // TODO: Purpose?
    public var program: String? = null,
    // TODO: Purpose?
    public var pt: PtSearchMode? = null,
    // TODO: Purpose?
    public var searchContext: HciReconstruction? = null,
    // TODO: Purpose?
    public var indoor: Boolean? = null,
    // TODO: Purpose?
    public var liveSearch: Boolean? = null,
    // TODO: Purpose?
    public var withICTAlternatives: Boolean? = null,

    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
    public var gisFltrL: List<HciGisFilter> = emptyList(),
    public var gisLocL: List<HciGisLocation> = emptyList(),
    public var gisPrefLocL: List<HciGisPreferredLocation> = emptyList(),

    // TODO: Purpose?
    public var bfAndroidEnd: String? = null,
    // TODO: Purpose?
    public var bfAndroidStart: String? = null,
    // TODO: Purpose?
    public var bfIOSEnd: String? = null,
    // TODO: Purpose?
    public var bfIOSStart: String? = null,
    // TODO: Purpose?
    public var cFGZ: Int? = null,
    // TODO: Purpose?
    public var cFLZ: Int? = null,
    // TODO: Purpose?
    public var cMZE: Int? = null,
    // TODO: Purpose?
    public var cNRA: Int? = null,
    // TODO: Purpose?
    public var cNUH: Int? = null,
    // TODO: Purpose?
    public var cNUMH: Int? = null,
    // TODO: Purpose?
    public var cNVOR: Int? = null,
    // TODO: Purpose?
    public var cOFFERR: Int? = null,
    // TODO: Purpose?
    public var cRFRA: Int? = null,
    // TODO: Purpose?
    public var cTFS: Int? = null,
    // TODO: Purpose?
    public var cVLKURZ: Int? = null,
    // TODO: Purpose?
    public var cVLMITTEL: Int? = null,
) : HciServiceRequest<HciTripSearchResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.TRIP_SEARCH

    @Serializable
    public class Via(
        public val loc: HciLocation,

        @Serializable(with = HciMinutesSerializer::class)
        public val min: Duration? = null
    )

    @Serializable
    public enum class PtSearchMode {
        FIRST,
        LAST,
        OFF,
        STD,
    }

    public companion object {
        public inline operator fun invoke(init: HciTripSearchRequest.() -> Unit): HciTripSearchRequest =
            HciTripSearchRequest().apply(init)
    }
}