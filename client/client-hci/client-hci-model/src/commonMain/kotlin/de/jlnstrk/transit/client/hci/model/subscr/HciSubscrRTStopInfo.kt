package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrRTStopInfo(
  public val arrDT: String? = null,
  public val at: Boolean = false,
  public val depDT: String? = null,
  public val loc: HciLocation,
  public val past: Boolean = false,
  public val platform: String? = null,
  public val platformCh: String? = null,
  public val arrDelay: Int = 0,
  public val depDelay: Int = 0,
  public val routeIdx: Int = 0,
)
