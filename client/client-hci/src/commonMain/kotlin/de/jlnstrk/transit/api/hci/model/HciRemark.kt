package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HafasRemarkCode
import de.jlnstrk.transit.api.hafas.HafasRemarkType
import kotlinx.serialization.Serializable

@Serializable
public data class HciRemark(
    /** The type of this remark */
    public val type: HafasRemarkType = HafasRemarkType.UNKNOWN,

    /** The code of this remark */
    public val code: HafasRemarkCode? = null,

    /** The priority of this remark */
    public val prio: Int?,

    /** The index of the associated icon into [HciCommon.icoL] */
    public val icoX: Int?,

    /** The text of this remark */
    public val txtN: String?,

    /** The summary of this remark */
    public val txtS: String?,

    public val sIdx: Int?,
)