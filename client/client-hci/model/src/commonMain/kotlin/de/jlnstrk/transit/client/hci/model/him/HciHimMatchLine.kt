package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMatchLine(
  public val cat: String? = null,
  public val lineId: String? = null,
  public val lineLong: String? = null,
  public val lineShort: String? = null,
  public val name: String? = null,
  public val op: String? = null,
  public val pid: String? = null,
  public val dirRefL: List<Int> = emptyList(),
  public val himIdL: List<String> = emptyList(),
  public val noLineL: List<HciHimMatchNoLine> = emptyList(),
  public val cls: Int = 0,
  public val isLine: Boolean = true,
  public val numAffJrn: Int = 0
)
