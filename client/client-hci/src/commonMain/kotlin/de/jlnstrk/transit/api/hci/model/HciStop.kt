@file:UseSerializers(
    HciLocalTimeSerializer.WithDayOffset::class,
    HciZoneOffsetSerializer::class
)

package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HafasPrognosisType
import de.jlnstrk.transit.api.hci.model.base.HciLocalTime
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciZoneOffsetSerializer
import de.jlnstrk.transit.util.ZoneOffset
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class HciStop(
    /** The stop's location's index into [HciCommon.locL] */
    public val locX: Int,

    /** The route index of this stop */
    public val idx: Int?,

    /** The arriving product's index into [HciCommon.prodL] */
    public val aProdX: Int?,

    /** The departing product's index into [HciCommon.prodL] */
    public val dProdX: Int?,

    /** The scheduled arrival time at this stop */
    public val aTimeS: HciLocalTime?,

    /** The scheduled departure time at this stop */
    public val dTimeS: HciLocalTime?,

    /** The realtime arrival time at this stop */
    public val aTimeR: HciLocalTime?,

    /** The realtime departure time at this stop */
    public val dTimeR: HciLocalTime?,

    /** The arrival time's timezone offset from the server zone */
    public val aTZOffset: ZoneOffset?,

    /** The departure time's timezone offset from the server zone */
    public val dTZOffset: ZoneOffset?,

    /** Whether the arrival at this stop is cancelled */
    public val aCncl: Boolean?,

    /** Whether the departure at this stop is cancelled */
    public val dCncl: Boolean?,

    /** The arrival time's underlying type of realtime prognosis */
    public val aProgType: HafasPrognosisType? = null,

    /** The departure time's underlying type of realtime prognosis */
    public val dProgType: HafasPrognosisType? = null,

    /** The name of the scheduled arrival platform */
    public val aPlatfS: String?,

    /** The scheduled arrival platform */
    public val aPltfS: HciPlatform?,

    /** The name of the scheduled departure platform */
    public val dPlatfS: String?,

    /** The scheduled departure platform */
    public val dPltfS: HciPlatform?,

    /** The realtime arrival platform */
    public val aPlatfR: String?,

    /** The realtime arrival platform */
    public val aPltfR: HciPlatform?,

    public val aPlatfCh: Boolean?,

    /** The name of the realtime departure platform */
    public val dPlatfR: String?,

    /** The realtime departure platform */
    public val dPltfR: HciPlatform?,

    public val dPlatfCh: Boolean?,

    // TODO: Purpose?
    public val dInS: Boolean?,

    // TODO: Purpose?
    public val dInR: Boolean?,

    public val aOutS: Boolean?,
    public val aOutR: Boolean?,

    /** The text describing the departure direction */
    public val dDirTxt: String?,
    public val dDirFlg: String?,

    public val type: Type?,
    // TODO: Purpose?
    public val isImp: Boolean?,
    public val dTrnCmpSX: TrainComposition?,

    /** The messages associated with this stop */
    public val msgL: List<HciMessage> = emptyList(),

    // TODO: Purpose?
    public val dTimeFS: F?,

    // TODO: Purpose?
    public val dTimeFR: F?,

    // TODO: Purpose?
    public val dTimeFC: F?,

    // TODO: Purpose?
    public val aTimeFS: F?,

    // TODO: Purpose?
    public val aTimeFR: F?,

    // TODO: Purpose?
    public val aTimeFC: F?,

    // TODO: Purpose?
    public val aCnclRtSrcX: Int?,

    // TODO: Purpose?
    public val dCnclRtSrcX: Int?,

    public val dTimeSCh: Boolean?,

    public val aHide: Boolean?,

    public val dHide: Boolean?,
) {

    // TODO: Purpose?
    @Serializable
    public data class F(
        public val styleX: Int,

        public val txtA: String?,
    )

    @Serializable
    public enum class Type {
        H, N
    }

    // TODO: Resolve
    @Serializable
    public data class TrainComposition(
        public val tcM: Int?,
        public val tcocX: List<Int> = emptyList(),
    )
}