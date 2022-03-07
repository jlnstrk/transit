package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffInfoBoxGroup(
  public val caption: String? = null,
  public val msgL: List<HciMessage> = emptyList(),
  public val tariffInfoBoxL: List<HciTariffInfoBox> = emptyList()
)
