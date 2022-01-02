package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocationRoute(
  public val endStation: String? = null,
  public val locX: Int,
  public val routeNum: String,
  public val startStation: String? = null
)
