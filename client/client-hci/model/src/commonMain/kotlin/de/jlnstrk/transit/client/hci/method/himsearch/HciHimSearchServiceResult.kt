package de.jlnstrk.transit.client.hci.method.himsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.him.HciHimMessage
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciHimSearchServiceResult(
  public val common: HciCommon? = null,
  public val msgL: List<HciHimMessage> = emptyList()
) : HciServiceResult()
