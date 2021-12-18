package de.jlnstrk.transit.client.hci.request.filter

import kotlinx.serialization.Serializable

@Serializable
public data class HciHimFilter(
    public val type: Type,
    public val mode: HciRequestFilterMode? = null,
    public val value: String? = null,
) {

    @Serializable
    public enum class Type {
        ADMIN,
        CAT,
        CH,
        COMP,
        DEPT,
        EID,
        HIMCAT,
        HIMID,
        HIMTAG,
        LINE,
        LINEID,
        META,
        OPR,
        PID,
        PROD,
        REG,
        SRC,
        STATION,
        TRAIN,
        TXT,
    }
}