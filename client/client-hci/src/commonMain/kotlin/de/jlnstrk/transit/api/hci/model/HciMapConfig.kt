package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciMapConfig(
    public val baseMapL: List<HciMapLayerExt> = emptyList(),
    public val overlayL: List<HciMapLayerExt> = emptyList(),
    public val tagL: List<String> = emptyList(),
    public val keyValueL: List<HciPair> = emptyList(),
)