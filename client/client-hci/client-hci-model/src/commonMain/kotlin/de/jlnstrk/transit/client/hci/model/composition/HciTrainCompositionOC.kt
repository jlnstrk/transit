package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTrainCompositionOC(
  public val c: String? = null,
  public val n: String? = null,
  public val r: Int? = null,
  public val v: Int = 0,
)
