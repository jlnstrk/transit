package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffPoolInfo
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciServerInformation(
  public val hafas_dir: String? = null,
  public val host: String? = null,
  public val planrt_file: String? = null,
  public val tariffPoolInfo: HciTariffPoolInfo? = null,
  public val trff: String? = null,
  public val user: String? = null,
  public val vers: String? = null,
  public val wd: String? = null,
  public val rmtL: List<String> = emptyList(),
  public val port: Int = 0
)
