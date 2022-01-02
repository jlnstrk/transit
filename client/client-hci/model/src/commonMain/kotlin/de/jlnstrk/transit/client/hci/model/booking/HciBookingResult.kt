package de.jlnstrk.transit.client.hci.model.booking

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.fare.HciFareCommon
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciBookingResult(
  public val BOG: HciBookingObjGroup? = null,
  public val FV: String? = null,
  public val common: HciFareCommon? = null,
  public val errCode: Int = 0,
  public val errMsg: String? = null
)
