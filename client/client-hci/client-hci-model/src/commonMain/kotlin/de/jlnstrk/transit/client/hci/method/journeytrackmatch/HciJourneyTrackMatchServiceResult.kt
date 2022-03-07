package de.jlnstrk.transit.client.hci.method.journeytrackmatch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciNamedValue
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyTrackMatchResult
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciJourneyTrackMatchServiceResult(
  public val common: HciCommon? = null,
  public val diagnostics: List<HciNamedValue> = emptyList(),
  public val matchResults: List<HciJourneyTrackMatchResult> = emptyList()
) : HciServiceResult()
