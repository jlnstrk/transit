package de.jlnstrk.transit.client.hci.model.client

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciClientFilterGui(
  public val icoX: Int? = null,
  public val txt: String? = null,
  public val txtA: String? = null,
  public val zoomMax: Int? = null,
  public val zoomMin: Int? = null,
  public val state: HciClientFilterGuiState = HciClientFilterGuiState.A,
  public val type: HciClientFilterGuiType = HciClientFilterGuiType.U
)
