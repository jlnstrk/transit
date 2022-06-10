package de.jlnstrk.transit.client.hci.model.text

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTextInstruction(
  public val id: String,
  public val locX: Int? = null,
  public val mode: HciTextInstructionMode,
  public val prodX: Int? = null,
  public val type: HciTextInstructionType,
  public val urlX: Int? = null,
)
