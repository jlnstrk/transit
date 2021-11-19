package de.jlnstrk.transit.api.hci.model.tariff

import de.jlnstrk.transit.api.hci.model.HciExternalContent
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import kotlinx.serialization.Serializable

@Serializable
public data class HciTariffInfoBox(
    public val description: String?,
    public val extCOnt: HciExternalContent?,
    public val fSecRefL: Int?,
    public val fareSetRefL: List<Int> = emptyList(),
    public val icoX: Int?,
    public val msgL: List<HciMessage> = emptyList(),
    public val price: HciTariffPrice?,
    public val subline: String?,
    public val tSecRefX: Int?,
    public val title: String?,
)