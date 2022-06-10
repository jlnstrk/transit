package de.jlnstrk.transit.client.hci.model.fare

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciFareCommon(
  public val FEL: List<HciFareEntity> = emptyList(),
)
