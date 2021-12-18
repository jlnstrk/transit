package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciTextInstructionInterval(
    public val startIndex: Int,
    public val endIndex: Int,
    public val textInstructionX: Int,
)
