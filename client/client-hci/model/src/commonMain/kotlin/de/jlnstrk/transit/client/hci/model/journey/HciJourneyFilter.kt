package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyFilter(
  public val meta: String? = null,
  public val type: HciJourneyFilterType,
  public val `value`: String? = null,
  public val locIdx: Int = -1,
  public val mode: HciJourneyFilterMode = HciJourneyFilterMode.UNDEF
)
