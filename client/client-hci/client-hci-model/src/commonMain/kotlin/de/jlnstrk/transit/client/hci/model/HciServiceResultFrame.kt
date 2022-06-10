package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciServiceResultFrame(
  public val ctx: String? = null,
  public val err: HciServiceError = HciServiceError.OK,
  public val errTxt: String? = null,
  public val errTxtOut: String? = null,
  public val id: String? = null,
  public val meth: HciServiceMethod? = null,
  public val res: HciServiceResult? = null,
  public val statist: String? = null,
)
