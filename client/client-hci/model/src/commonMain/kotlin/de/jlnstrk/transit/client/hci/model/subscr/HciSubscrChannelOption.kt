package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrChannelOption(
  public val type: HciSubscrChannelOptionType,
  public val `value`: String
)
