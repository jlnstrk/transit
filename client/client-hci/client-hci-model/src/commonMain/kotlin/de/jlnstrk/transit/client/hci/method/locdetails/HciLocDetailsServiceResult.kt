package de.jlnstrk.transit.client.hci.method.locdetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.event.HciEventLocation
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciLocDetailsServiceResult(
  public val common: HciCommon? = null,
  public val evtLocL: List<HciEventLocation> = emptyList(),
  public val locL: List<HciLocation> = emptyList()
) : HciServiceResult()
