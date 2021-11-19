package de.jlnstrk.transit.api.hci.model.tariff

import de.jlnstrk.transit.api.hci.model.message.HciMessage
import kotlinx.serialization.Serializable

@Serializable
public data class HciTariffInfoBoxGroup(
    public val caption: String?,
    public val msgL: List<HciMessage> = emptyList(),
    public val tariffInfoBoxL: List<HciTariffInfoBox> = emptyList(),
)