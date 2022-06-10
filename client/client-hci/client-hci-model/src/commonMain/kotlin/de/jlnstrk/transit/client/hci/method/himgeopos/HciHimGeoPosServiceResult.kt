package de.jlnstrk.transit.client.hci.method.himgeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciHimGeoPosServiceResult(
  public val common: HciCommon? = null,
  public val lastUpd: String? = null,
  public val edgeRefL: List<Int> = emptyList(),
  public val msgRefL: List<Int> = emptyList(),
  public val regionRefL: List<Int> = emptyList(),
) : HciServiceResult()
