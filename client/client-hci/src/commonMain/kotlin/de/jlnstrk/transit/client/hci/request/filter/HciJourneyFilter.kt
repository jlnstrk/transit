package de.jlnstrk.transit.client.hci.request.filter

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciJourneyFilter(
    public val type: Type,
    public val mode: HciRequestFilterMode,
    public val value: String? = null,
    public val meta: String? = null,
    public val locIdx: Int? = null,
) {

    @HciModel("1.39")
    @Serializable
    public enum class Type {
        ADM,
        ATTRF,
        ATTRJ,
        ATTRL,
        BC,
        CAT,
        COUCH,
        CTX_RECON,
        DFLG,
        DID,
        DIR,
        DIRECT,
        FIDO,
        FIDSOURCE,
        GISPROD,
        GROUP,
        INFOTEXTS,
        JID,
        LID,
        LINE,
        LINEID,
        META,
        NAME,
        NUM,
        OP,
        PARAM,
        PID,
        PROD,
        ROUTE,
        SLEEP,
        STATIONS,
        UIC,
    }
}