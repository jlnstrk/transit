package de.jlnstrk.transit.client.hci.model.connection

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciConnectionScoring(
  public val conScoreL: List<HciConnectionScore> = emptyList(),
  public val icoX: Int? = null,
  public val name: String? = null,
  public val type: HciConnectionScoringType,
)
