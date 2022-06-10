package de.jlnstrk.transit.client.hci.method.graphgeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciGraphMatch
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciGraphGeoPosServiceResult(
  public val common: HciCommon? = null,
  public val graphMatchL: List<HciGraphMatch> = emptyList(),
) : HciServiceResult()
