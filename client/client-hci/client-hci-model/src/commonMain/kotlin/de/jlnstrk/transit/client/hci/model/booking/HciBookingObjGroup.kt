package de.jlnstrk.transit.client.hci.model.booking

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.fare.HciFarePrice
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciBookingObjGroup(
  public val ALT: Boolean = false,
  public val COMB: Boolean = false,
  public val OPT: Boolean = false,
  public val P: String? = null,
  public val PRC: HciFarePrice? = null,
  public val SEQ: Boolean = false,
  public val trfCtx: String? = null,
  public val type: String? = null,
  public val BOGL: List<HciBookingObjGroup> = emptyList(),
  public val BOL: List<HciBookingObj> = emptyList(),
  public val BVL: List<HciBookingVehicle> = emptyList(),
  public val DESCR: List<String> = emptyList(),
)
