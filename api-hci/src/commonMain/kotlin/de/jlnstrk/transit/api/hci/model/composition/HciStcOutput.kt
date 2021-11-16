package de.jlnstrk.transit.api.hci.model.composition

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciStcOutput(
    public val dir: HciStcLeavingDirection?,
    public val groupL: List<Int> = emptyList(),
)