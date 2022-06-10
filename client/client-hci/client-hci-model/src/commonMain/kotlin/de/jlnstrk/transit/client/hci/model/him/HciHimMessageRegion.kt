package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import de.jlnstrk.transit.client.hci.model.HciPolylineGroup
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRing
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMessageRegion(
  public val icoCrd: HciCoord? = null,
  public val icoX: Int? = null,
  public val id: String? = null,
  public val name: String? = null,
  public val polyG: HciPolylineGroup? = null,
  public val ring: HciGeoRing? = null,
  public val msgRefL: List<Int> = emptyList(),
  public val polyTypeL: List<Boolean> = emptyList(),
)
