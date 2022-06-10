package de.jlnstrk.transit.client.hci.model.gui

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGuiElement(
  public val caption: String? = null,
  public val defOptX: Int? = null,
  public val icoX: Int? = null,
  public val id: String? = null,
  public val text: String? = null,
  public val type: HciGuiElementType,
  public val optL: List<HciGuiElementOption> = emptyList(),
  public val subElmL: List<Int> = emptyList(),
  public val state: HciGuiElementState = HciGuiElementState.A,
)
