package de.jlnstrk.transit.client.hci.model.gui

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGuiElementOption(
  public val actL: List<HciGuiElementAction> = emptyList(),
  public val icoX: Int? = null,
  public val text: String? = null,
  public val `value`: String? = null
)
