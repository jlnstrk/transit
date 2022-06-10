package de.jlnstrk.transit.client.hci.method.linedetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciLine
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciLineDetailsServiceResult(
  public val common: HciCommon? = null,
  public val line: HciLine? = null,
) : HciServiceResult()
