package de.jlnstrk.transit.api.hci.model.message

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciColor
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciMessage(
    public val type: Type,
    public var cntL: Set<HciMessageContent> = emptySet(),
    public val dspl: HciMessageDisplay?,
    public val extCX: Int?,
    public val fIdx: Int?,
    public val fLocX: Int?,
    public val frmL: Set<HciMessageFormat> = emptySet(),
    public val himX: Int?,
    public val minor: Int?,
    public val persist: Boolean?,
    public val prio: Int?,
    public val remX: Int?,
    public val sort: Int?,
    public val sty: HciMessageStyle?,
    public val tIdx: Int?,
    public val tLocX: Int?,
    public val tagL: Set<HciMessageTag> = emptySet(),
    public val trfMsgX: Int?,
    public val txtC: HciColor?,
) {

    @HciModel("1.39")
    @Serializable
    public enum class Type {
        HIM,
        REM,
    }
}