package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciNamedValue
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyTrackPoint(
  public val accuracy: Int? = null,
  public val direction: Int? = null,
  public val lineName: String? = null,
  public val loc: HciLocation? = null,
  public val product: Int? = null,
  public val seId: String? = null,
  public val speed: Int? = null,
  public val timestamp: String? = null,
  public val trainName: String? = null,
  public val probabilities: List<HciNamedValue> = emptyList(),
  public val source: HciJourneyTrackPointSourceType = HciJourneyTrackPointSourceType.GPS,
)
