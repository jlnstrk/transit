package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciExternalContent
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffInfoBox(
  public val description: String? = null,
  public val extCont: HciExternalContent? = null,
  public val fSecRefX: Int? = null,
  public val icoX: Int? = null,
  public val price: HciTariffPrice? = null,
  public val subline: String? = null,
  public val tSecRefX: Int? = null,
  public val title: String? = null,
  public val fareSetRefL: List<Int> = emptyList(),
  public val msgL: List<HciMessage> = emptyList()
)
