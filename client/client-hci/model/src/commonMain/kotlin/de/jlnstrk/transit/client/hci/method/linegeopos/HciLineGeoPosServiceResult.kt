package de.jlnstrk.transit.client.hci.method.linegeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciLine
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciLineGeoPosServiceResult(
  public val common: HciCommon? = null,
  public val lineL: List<HciLine> = emptyList()
) : HciServiceResult()
