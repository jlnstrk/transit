@file:UseSerializers(
    HciLocalTimeSerializer::class,
    HciLocalTimeSerializer.WithDayOffset::class,
    HciLocalDateSerializer::class
)

package de.jlnstrk.transit.api.hci.model.him

import de.jlnstrk.transit.api.hci.model.HciServiceDays
import de.jlnstrk.transit.api.hci.model.base.HciLocalTime
import de.jlnstrk.transit.api.hci.model.HciCommon
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class HciHimMessage(
    /** The id of this message in HIM */
    public val hid: String,

    /** Whether this message is active */
    public val act: Boolean,

    /** The head text of this message */
    public val head: String?,

    /** The lead text of this message */
    public val lead: String?,

    /** The body text of this message */
    public val text: String?,

    /** The index of the associated icon into [HciCommon.icoL] */
    public val icoX: Int?,

    /** The priority of this him message */
    public val prio: Int,

    /** The index of the first location this message applies to into [HciCommon.locL] */
    public val fLocX: Int?,

    /** The index of the last location this message applies to into [HciCommon.locL] */
    public val tLocX: Int?,

    /** The affiliated product types as bitmask */
    public val prod: Int,

    /** The references to affiliated products into [HciCommon.prodL] */
    public val affProdRefL: List<Int> = emptyList(),

    /** The references to affiliated regions into [HciCommon.himMsgRegionL] */
    public val regionRefL: List<Int> = emptyList(),

    public val rRefL: List<Int> = emptyList(),

    /** The date of the last modification to this message */
    public val lModDate: LocalDate,

    /** The time of the last modification to this message */
    public val lModTime: LocalTime,

    /** The starting date of the period this message applies to */
    public val sDate: LocalDate,

    /** The starting time of the period this message applies to */
    public val sTime: LocalTime,

    /** The end date of the period this message applies to */
    public val eDate: LocalDate,

    /** The end time of the period this message applies to */
    public val eTime: LocalTime,

    /** The daily starting time of when this message applies */
    public val sDaily: HciLocalTime?,

    /** The daily end time of when this him message applies */
    public val eDaily: HciLocalTime?,

    // TODO: comp = company?
    public val comp: String?,

    /** The category of this him message */
    public val cat: Int?,

    /** The references to affiliated categories into [HciCommon.himMsgCatL] */
    public val catRefL: List<Int> = emptyList(),

    /** The references to affiliated edges into [HciCommon.himMsgEdgeL] */
    public val edgeRefL: List<Int> = emptyList(),

    /** The references to affiliated events into [HciCommon.himMsgEventL] */
    public val eventRefL: List<Int> = emptyList(),

    public val gTagXL: List<Int> = emptyList(),

    /** The publication channel of this message */
    public val pubChL: List<Channel> = emptyList(),

    /** The days that this him message applies to */
    public val vDays: HciServiceDays?,

    // TODO: Purpose?
    public val altStart: String?,

    // TODO: Purpose?
    public val altEnd: String?,

    public val src: Int?,

    public val fIdx: Int?,

    public val tIdx: Int?,
) {

    @Serializable
    public data class Channel(
        public val fDate: LocalDate,
        public val fTime: LocalTime,
        public val name: String,
        public val tDate: LocalDate,
        public val tTime: LocalTime,
        public val uRefL: List<Int> = emptyList()
    )
}