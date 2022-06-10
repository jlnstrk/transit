package de.jlnstrk.transit.client.hci.model.client

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciClientFilter(
  public val fid: String,
  public val gui: HciClientFilterGui? = null,
  public val optL: List<HciClientFilterOption> = emptyList(),
  public val persist: Boolean = false,
)
