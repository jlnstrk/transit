package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTrainComposition(
  public val stcDataX: Int? = null,
  public val stcLDir: HciSimpleTrainCompositionLeavingDirection? = null,
  public val tcpdX: Int? = null,
  public val tctcX: Int? = null,
  public val stcGX: List<Int> = emptyList(),
  public val tcocX: List<Int> = emptyList(),
  public val tcM: Int = 0,
)
