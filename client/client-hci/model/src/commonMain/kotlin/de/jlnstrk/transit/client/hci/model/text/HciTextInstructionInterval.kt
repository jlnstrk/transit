package de.jlnstrk.transit.client.hci.model.text

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTextInstructionInterval(
  public val endIndex: Int,
  public val startIndex: Int,
  public val textInstructionX: Int
)
