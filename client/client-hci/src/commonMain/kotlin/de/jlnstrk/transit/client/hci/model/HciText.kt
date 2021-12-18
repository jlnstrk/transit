package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciText(
    public val text: String,
    public val textInstructionIntervalL: List<HciTextInstructionInterval> = emptyList(),
)
