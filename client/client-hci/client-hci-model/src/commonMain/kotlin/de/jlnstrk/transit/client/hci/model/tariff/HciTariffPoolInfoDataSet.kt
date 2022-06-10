package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffPoolInfoDataSet(
  public val extraInfo: String? = null,
  public val filePath: String,
  public val supplier: String,
  public val validFrom: String,
  public val validTo: String,
  public val version: String? = null,
)
