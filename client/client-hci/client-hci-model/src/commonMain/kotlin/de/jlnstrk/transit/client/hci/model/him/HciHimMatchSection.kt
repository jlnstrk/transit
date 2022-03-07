package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyStop
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMatchSection(
  public val fMatchSt: HciJourneyStop? = null,
  public val lMatchSt: HciJourneyStop? = null
)
