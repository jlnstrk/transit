package de.jlnstrk.transit.client.hci.method.matchme

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciMatchMeServiceResult(
  public val common: HciCommon? = null,
  public val fpB: String? = null,
  public val fpE: String? = null,
  public val jnyL: List<HciJourney> = emptyList(),
  public val planrtTS: String? = null
) : HciServiceResult()
