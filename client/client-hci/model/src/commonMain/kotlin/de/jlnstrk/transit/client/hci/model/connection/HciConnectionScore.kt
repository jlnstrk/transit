package de.jlnstrk.transit.client.hci.model.connection

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciConnectionScore(
  public val conRefL: List<Int> = emptyList(),
  public val score: Long,
  public val scoreS: String
)
