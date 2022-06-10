package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyStop
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMatchAffectedRoute(
  public val dirL: List<HciHimMatchAffectedRouteDirection> = emptyList(),
  public val passL: List<HciJourneyStop> = emptyList(),
)
