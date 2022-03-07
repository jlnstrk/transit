package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciMapConfig(
  public val baseMapL: List<HciMapLayerExt> = emptyList(),
  public val keyValueL: List<HciPropertyPair> = emptyList(),
  public val overlayL: List<HciMapLayerExt> = emptyList(),
  public val tagL: List<String> = emptyList()
)
