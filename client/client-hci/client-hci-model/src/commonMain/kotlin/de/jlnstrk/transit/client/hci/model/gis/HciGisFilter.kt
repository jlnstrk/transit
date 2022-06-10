package de.jlnstrk.transit.client.hci.model.gis

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGisFilter(
  public val meta: String? = null,
  public val mode: HciGisFilterMode,
  public val profile: HciGisProfile? = null,
  public val type: HciGisFilterType,
)
