package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciMatchLocation
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMatchSingleJourneyFilter(
  public val matchLocL: List<HciMatchLocation> = emptyList(),
  public val numInfo: String,
)
