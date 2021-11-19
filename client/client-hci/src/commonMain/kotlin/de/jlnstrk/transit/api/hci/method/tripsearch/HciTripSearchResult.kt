package de.jlnstrk.transit.api.hci.method.tripsearch

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import de.jlnstrk.transit.api.hci.model.HciSearchOnTripContext
import de.jlnstrk.transit.api.hci.model.connection.HciConnection
import de.jlnstrk.transit.api.hci.model.connection.HciConnectionScoreGroup
import de.jlnstrk.transit.api.hci.model.connection.HciConnectionScoreGroupSettings
import de.jlnstrk.transit.api.hci.model.tariff.HciTariffResult
import de.jlnstrk.transit.api.hci.response.HciScheduleResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciTripSearchResult(
    /** The connection score group settings used for the outgoing connections */
    public val outConGrpSettings: HciConnectionScoreGroupSettings?,
    /** The connection score groups computed for the outgoing connections (Legacy!) */
    public val outConGrpL: List<HciConnectionScoreGroup> = emptyList(),
    /** Global messages applying to the outgoing connections */
    public val outGlobMsgL: List<HciMessage> = emptyList(),
    /** The computed outgoing connections */
    public val outConL: List<HciConnection> = emptyList(),
    /** The trip search context for backward scrolling of outgoing connections.
     * To be passed with [HciTripSearchRequest.ctxScroll] */
    public val outCtxScrB: String?,
    /** The trip search context for forward scrolling of outgoing connections.
     * To be passed with [HciTripSearchRequest.ctxScroll] */
    public val outCtxScrF: String?,

    /** The connection score group settings used for the returning connections */
    public val retConGrpSettings: HciConnectionScoreGroupSettings?,
    /** The connection score groups computed for the returning connections (Legacy!) */
    public val retConGrpL: List<HciConnectionScoreGroup> = emptyList(),
    /** Global messages applying to the returning connections */
    public val retGlobMsgL: List<HciMessage> = emptyList(),
    /** The computed returning connections */
    public val retConL: List<HciConnection> = emptyList(),
    /** The trip search context for backward scrolling of returning connections.
     * To be passed with [HciTripSearchRequest.ctxScroll] */
    public val retCtxScrB: String?,
    /** The trip search context for forward scrolling of returning connections.
     * To be passed with [HciTripSearchRequest.ctxScroll] */
    public val retCtxScrF: String?,

    /** The tariff result for the connections */
    public val trfRes: HciTariffResult?,
    /** The search on trip context of this trip search result */
    public val sotCtxt: HciSearchOnTripContext?,

    // TODO: Meaning + Proper name
    public val bfATS: Int?,
    // TODO: Meaning + Proper name
    public val bfIOSTS: Int?,
) : HciScheduleResult()