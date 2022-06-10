package de.jlnstrk.transit.client.hci.method.eventlocgeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.event.HciEventLocation
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciEventLocGeoPosServiceResult(
  public val common: HciCommon? = null,
  public val evtLocL: List<HciEventLocation> = emptyList(),
) : HciServiceResult()
