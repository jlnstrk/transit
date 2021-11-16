package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hci.config.Hci
import kotlinx.serialization.Serializable

@Serializable
public data class HciProduct(
    @Hci("1.16")
    public val pid: String?,

    public val name: String,

    public val nameS: String?,

    public val number: String?,

    public val oprX: Int?,

    public val icoX: Int?,

    public val cls: Int?,

    public val prodCtx: Context?,

    public val himIdL: List<String> = emptyList(),

    @Hci("1.16")
    public val stat: Stat?
) {

    @Serializable
    public data class Context(
        @Hci("1.16")
        public val admin: String?,

        public val catIn: String?,

        public val catCode: String?,

        public val catOut: String?,

        public val catOutL: String?,

        public val catOutS: String?,

        public val line: String?,

        @Hci("1.16")
        public val lineId: String?,

        @Hci("1.16")
        public val matchId: String?,

        public val name: String?,

        public val num: String?,
    )

    @Hci("1.16")
    @Serializable
    public data class Stat(
        public val cnt: Int,
        public val rt: Int,
        // TODO: Purpose?
        public val ont: Int,
        public val cncl: Int,
        // TODO: Name + Purpose
        public val delGrpL: List<Int> = emptyList(),
        // TODO: Name + Purpose
        public val delCntL: List<Int> = emptyList(),
        public val him: Int
    )
}