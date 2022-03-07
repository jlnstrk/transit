package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTrafficMessage(
  public val desc: String? = null,
  public val extId: String? = null,
  public val icoX: Int? = null,
  public val locX: Int? = null,
  public val name: String? = null,
  public val polyG: HciPolylineGroup? = null,
  public val tmid: Int? = null,
  public val avoided: Boolean = false,
  public val type: HciTrafficMessageType = HciTrafficMessageType.U
)
