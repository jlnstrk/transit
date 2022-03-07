package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyGroup(
  public val icoX: Int? = null,
  public val name: String? = null,
  public val grpItemL: List<HciJourneyGroupItem> = emptyList(),
  public val grpL: List<HciJourneyGroup> = emptyList(),
  public val msgL: List<HciMessage> = emptyList(),
  public val type: HciJourneyGroupType = HciJourneyGroupType.ROOT
)
