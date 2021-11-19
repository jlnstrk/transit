package de.jlnstrk.transit.api.hci.model.composition

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciStcGroup(
    public val carL: List<Int> = emptyList(),
    public val liXL: List<Int> = emptyList(),
    public val dest: String?
)