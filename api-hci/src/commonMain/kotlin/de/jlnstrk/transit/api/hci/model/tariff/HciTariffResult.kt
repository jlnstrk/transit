package de.jlnstrk.transit.api.hci.model.tariff

import de.jlnstrk.transit.api.hci.model.HciExternalContent
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public data class HciTariffResult(
    public val addData: String?,
    public val bkgData: JsonElement?,
    public val clickout: String?,
    public val extCont: HciExternalContent?,
    public val extContActionBar: HciExternalContent?,
    public val extContConSum: HciExternalContent?,
    public val fareSetL: List<HciTariffFareSet> = emptyList(),
    public val msgL: List<HciMessage> = emptyList(),
    public val reloadProfile: String?,
    public val statusCode: HciTariffStatusCode?,
    public val statusText: String?,
    public val tariffInfoBoxGroupL: List<HciTariffInfoBoxGroup> = emptyList(),
    public val totalPrice: HciTariffPrice?,
    public val trfCtxRecon: String?,
    public val variantL: List<HciTariffVariant> = emptyList(),
)