package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciReachPos(
  public val chg: Int = -1,
  public val dur: Int = -1,
  public val lastLocX: Int? = null,
  public val locX: Int? = null,
  public val prodX: Int? = null,
)
