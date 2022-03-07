package de.jlnstrk.transit.client.hci.method.locmatch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.location.HciLocationMatch
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciLocMatchServiceResult(
  public val common: HciCommon? = null,
  public val match: HciLocationMatch
) : HciServiceResult()
