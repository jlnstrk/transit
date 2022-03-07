package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciServiceRequestFrame(
  public val cfg: HciRequestConfig? = null,
  public val ctx: String? = null,
  public val id: String? = null,
  public val meth: HciServiceMethod,
  public val req: HciServiceRequest
)
