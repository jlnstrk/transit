package de.jlnstrk.transit.client.hci.method.himaffect

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciHimAffectServiceResult(
  public val affLocRefL: List<Int> = emptyList(),
  public val common: HciCommon? = null,
) : HciServiceResult()
