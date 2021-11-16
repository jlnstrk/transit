@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciDurationSerializer::class
)

package de.jlnstrk.transit.api.hci.model.connection

import de.jlnstrk.transit.api.hafas.HafasReliabilityType
import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.*
import de.jlnstrk.transit.api.hci.model.composition.HciTrainComposition
import de.jlnstrk.transit.api.hci.model.eco.HciEco
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import de.jlnstrk.transit.api.hci.model.recon.HciReconstruction
import de.jlnstrk.transit.api.hci.model.tariff.HciTariffReference
import de.jlnstrk.transit.api.hci.model.tariff.HciTariffResult
import de.jlnstrk.transit.api.hci.serializer.time.HciDurationSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciMinutesSerializer
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public class HciConnection(
    /** The id of this connection */
    public val cid: String,
    /** The checksum of this connection */
    public val cksum: String,
    // TODO: Purpose?
    public val cksumDti: String?,

    /** The date of this connection */
    public val date: LocalDate,
    /** The service days this connection runs on */
    public val sDays: HciServiceDays?,

    /** The duration of this connection */
    public val dur: Duration,
    /** The scheduled duration of this connection */
    public val durS: Duration?,
    /** The realtime duration of this connection */
    public val durR: Duration?,

    // TODO: Meaning?
    @Serializable(with = HciMinutesSerializer::class)
    public val useableTime: Duration?,

    /** The number of changes with this connection */
    public val chg: Int?,
    /** The distance covered by this connection in meters */
    public val dist: Int?,

    /** The type of origin of this connection */
    public val originType: OriginType?,
    /** Stop data concerning the initial departure */
    public val dep: HciStop,
    /** Stop data concerning the final arrival */
    public val arr: HciStop,

    /** The train composition of the initially departing vehicle */
    public val dTrnCmpSX: HciTrainComposition?,
    /** The train composition of the final vehicle on arrival */
    public val aTrnCmpSX: HciTrainComposition?,
    /** The load status of this connection */
    public val tcocXL: List<Int> = emptyList(),

    /** Whether this connection has alternatives */
    public val hasAlt: Boolean?,
    // TODO: Meaning?
    public val hasImpRem: Boolean?,
    // TODO: Meaning?
    public val hasIndividualChangeTimes: Boolean?,

    /** The eco footprint associated with using this connection */
    public val eco: HciEco?,
    // TODO: Purpose?
    public val ecoCmpL: List<HciEco> = emptyList(),
    // TODO: Purpose?
    public val ecoEntryUrl: String?,

    /** The scheduled frequency of this connection */
    public val freq: HciFrequency?,
    /** The realtime frequency of this connection */
    public val freqRT: HciFrequency?,
    /** The reliability of this connection */
    public val reliability: Reliability?,

    /** The problematic section on this eonnection */
    public val badSecRefX: Int?,
    /** Whether this connection is not rideable */
    public val isNotRdbl: Boolean?,
    /** The error that applies to this connection */
    public val err: ErrorType?,
    /** The status of this connection */
    public val conStatus: Status?,
    /** The messages associated with this connection */
    public val msgL: List<HciMessage> = emptyList(),

    /** Whether this connection is an alternative */
    public val isAlt: Boolean?,
    // TODO: Meaning?
    public val isPref: Boolean?,

    /** The reconstruction state of this connection */
    public val recState: HciReconstruction.State?,
    /** The reconstruction data of this connection */
    public val recon: HciReconstruction?,
    /** The reconstruction context of this connection (legacy) */
    public val ctxRecon: String?,

    /** The reservation state of this connection */
    public val resState: HciReservationState?,
    /** The reservation recommendation for this connection */
    public val resRecommendation: HciReservationRecommendation?,

    /** The sections part of this connection */
    public val secL: List<HciSection> = emptyList(),

    /** The search on trip context of this connection */
    public val sotCtxt: HciSearchOnTripContext?,
    /** The search on trip rating of this connection */
    public val sotRating: Int?,
    /** Whether this is a search on trip connection */
    public val isSotCon: Boolean?,

    /** The tariff result for this connection */
    public val trfRes: HciTariffResult?,
    /** The overview tariff references for this connection */
    public val ovwTrfRefL: List<HciTariffReference> = emptyList(),

    /** The subscription state of this connection */
    public val conSubscr: SubscriptionState?,
    /** The interval subscription state of this connection */
    public val intvlSubscr: SubscriptionState?,

    // TODO: Purpose?
    public val parConL: List<HciContent> = emptyList(),
    // TODO: Purpose?
    public val combinedMinDuration: Duration?,
    // TODO: Purpose?
    public val combinedCount: Int?,
    // TODO: Purpose?
    public val showARSLink: Boolean?,
    // TODO: Purpose?
    public val dbReisePlanStorageData: HciDBReiseplanStorageData?,
) {

    // TODO: Meaning + Domain
    @Serializable
    public enum class SubscriptionState {
        // TODO: Meaning?
        F,

        // TODO: Meaning?
        N,

        // TODO: Meaning?
        P,

        // TODO: Meaning?
        U,
    }

    @Serializable
    public enum class OriginType {
        INITIAL,
        RETRY_DOUBLE_RADIUS,
        RETRY_SHARP,
        RETRY_UNSHARP,
    }

    @Serializable
    public data class Status(
        /** Whether this connection is considered convenient */
        public val convenient: Boolean?,
        /** Whether this connection runs daily */
        public val daily: Boolean?,
        /** Whether this connection runs a detour */
        public val detour: Boolean?,
        /** Whether this connection is direct */
        public val direct: Boolean?,
        /** Whether this connection is considered economic */
        public val economic: Boolean?,
        /** A hint associated with the status of this connection */
        public val hint: String?,
        /** Whether this connection is direct but slow */
        public val slowDirect: Boolean?,
        /** Whether this connection employs a special train */
        public val specialtrain: Boolean?,
        /** Whether this connection is direct while being considered suboptimal */
        public val subOptimalDirect: Boolean?,
        /** ¯\_(ツ)_/¯ */
        public val ukNationalRouteingGuideFailure: Boolean?,
    )

    @Serializable
    public enum class ErrorType {
        EXP,
        OK,
        OK_LATE,
        RCF,
        REM,
        WARN,
    }

    @Serializable
    public data class Reliability(
        public val alternative: HafasReliabilityType,
        public val original: HafasReliabilityType,
    )
}