package de.jlnstrk.transit.client.hci.method.sharelocation

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciShareLocationServiceResult(
  public val common: HciCommon? = null,
  public val subject: String? = null,
  public val text: String? = null,
  public val urlL: List<Int> = emptyList(),
) : HciServiceResult()
