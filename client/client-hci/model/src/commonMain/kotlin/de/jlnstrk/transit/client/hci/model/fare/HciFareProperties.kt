package de.jlnstrk.transit.client.hci.model.fare

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciFareProperties(
  public val CC: String? = null,
  public val CF: String? = null,
  public val DF: String? = null,
  public val IR: Boolean = false,
  public val RC: String? = null,
  public val TF: Boolean = false,
  public val NV: List<HciFareNamedValue> = emptyList(),
  public val FC: Int = 0,
  public val LA: Int = 0,
  public val LN: Int = 0,
  public val PS: Int = 0,
  public val UA: Int = 0,
  public val UN: Int = 0
)
