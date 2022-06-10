package de.jlnstrk.transit.client.hci.model.fare

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciFareEntity(
  public val ID: List<String> = emptyList(),
  public val ON: List<String> = emptyList(),
  public val PN: List<String> = emptyList(),
  public val XV: List<String> = emptyList(),
)
