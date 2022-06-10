package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGraphMatch(
  public val affPolyGrp: HciPolylineGroup? = null,
  public val dist: Int,
  public val matchPt: HciCoord,
)
