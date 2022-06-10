package de.jlnstrk.transit.client.hci.model.text

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciText(
  public val text: String,
  public val textInstructionIntervalL: List<HciTextInstructionInterval> = emptyList(),
)
