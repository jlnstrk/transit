package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciContextProduct(
  public val addName: String? = null,
  public val admin: String? = null,
  public val catCode: String? = null,
  public val catIn: String? = null,
  public val catOut: String? = null,
  public val catOutL: String? = null,
  public val catOutS: String? = null,
  public val line: String? = null,
  public val lineId: String? = null,
  public val locTraf: String? = null,
  public val matchId: String? = null,
  public val name: String? = null,
  public val num: String? = null,
  public val outCtrl: String? = null,
  public val ship: String? = null,
  public val surcharge: String? = null,
  public val tarGr: String? = null
)
