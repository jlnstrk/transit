package de.jlnstrk.transit.api.hci.model.tariff

import de.jlnstrk.transit.api.hci.model.HciExternalContent
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import kotlinx.serialization.Serializable

@Serializable
public data class HciTariffFare(
    public val addData: String?,
    public val addHint: String?,
    public val bookStatus: String?,
    public val buttonText: String?,
    public val circa: Boolean?,
    public val cur: String?,
    public val desc: String?,
    public val descOverv: String?,
    public val dtl: String?,
    public val extCont: HciExternalContent?,
    public val fSecRefX: Int?,
    public val fStopRefX: Int?,
    public val filterProps: HciTariffFilterProps?,
    public val hasCity: Boolean?,
    public val icoX: Int?,
    public val infoExt: HciExternalContent?,
    public val isBookable: Boolean?,
    public val isFromPrice: Boolean?,
    public val isPartPrice: Boolean?,
    public val isUpsell: Boolean?,
    public val msgL: List<HciMessage> = emptyList(),
    public val name: String,
    public val prc: Int?,
    public val price: HciTariffPrice?,
    public val tSecRefX: Int?,
    public val tStopRefX: Int?,
    public val targetCtx: String?,
    public val ticketL: List<HciTariffTicket> = emptyList(),
    public val verbundName: String?,
    public val shpCtx: String?,
)