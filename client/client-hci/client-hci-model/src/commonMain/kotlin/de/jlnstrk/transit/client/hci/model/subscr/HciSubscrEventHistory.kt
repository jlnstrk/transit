package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrEventHistory(
  public val himEvents: List<HciSubscrEventHIM> = emptyList(),
  public val rtEvents: List<HciSubscrEventRT> = emptyList(),
)
