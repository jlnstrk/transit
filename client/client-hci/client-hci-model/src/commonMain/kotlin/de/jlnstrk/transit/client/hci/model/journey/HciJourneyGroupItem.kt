package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyGroupItem(
  public val icoX: Int? = null,
  public val jnyRef: Int? = null,
  public val msgL: List<HciMessage> = emptyList(),
)
