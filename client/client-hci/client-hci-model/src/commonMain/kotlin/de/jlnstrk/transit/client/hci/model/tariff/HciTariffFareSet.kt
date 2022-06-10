package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffFareSet(
  public val addData: String? = null,
  public val desc: String? = null,
  public val fSecRefX: Int? = null,
  public val fStopRefX: Int? = null,
  public val icoX: Int? = null,
  public val name: String? = null,
  public val tSecRefX: Int? = null,
  public val tStopRefX: Int? = null,
  public val urlX: Int? = null,
  public val fareL: List<HciTariffFare> = emptyList(),
  public val msgL: List<HciMessage> = emptyList(),
)
