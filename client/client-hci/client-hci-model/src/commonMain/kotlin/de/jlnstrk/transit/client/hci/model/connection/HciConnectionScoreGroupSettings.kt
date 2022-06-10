package de.jlnstrk.transit.client.hci.model.connection

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciConnectionScoreGroupSettings(
  public val conGrpL: List<HciConnectionScoreGroup> = emptyList(),
  public val selectL: List<HciConnectionScoreGroupSelection> = emptyList(),
  public val variant: HciConnectionScoreGroupSelectionVariant =
      HciConnectionScoreGroupSelectionVariant.RADIO,
)
