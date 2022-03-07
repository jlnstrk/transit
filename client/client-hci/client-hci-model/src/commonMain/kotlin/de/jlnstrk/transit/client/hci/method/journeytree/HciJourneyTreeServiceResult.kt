package de.jlnstrk.transit.client.hci.method.journeytree

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyTreeNode
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciJourneyTreeServiceResult(
  public val common: HciCommon? = null,
  public val jnyTreeNodeL: List<HciJourneyTreeNode> = emptyList()
) : HciServiceResult()
