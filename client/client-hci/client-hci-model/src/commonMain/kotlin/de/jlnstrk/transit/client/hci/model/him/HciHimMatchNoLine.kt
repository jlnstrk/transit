package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMatchNoLine(
  public val dirRefL: List<Int> = emptyList(),
  public val himIdL: List<String> = emptyList(),
  public val name: String? = null,
)
