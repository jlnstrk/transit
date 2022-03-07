package de.jlnstrk.transit.client.hci.model.gui

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGuiElementAction(
  public val tarElmState: HciGuiElementState? = null,
  public val tarElmX: Int,
  public val tarOptX: Int? = null
)
