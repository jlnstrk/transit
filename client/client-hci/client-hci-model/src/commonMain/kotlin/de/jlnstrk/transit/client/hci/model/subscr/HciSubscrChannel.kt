package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrChannel(
  public val active: Boolean = true,
  public val address: String? = null,
  public val channelId: String,
  public val confirmed: Boolean = true,
  public val language: String? = null,
  public val name: String? = null,
  public val options: List<HciSubscrChannelOption> = emptyList(),
  public val subscrTypes: List<HciSubscrType> = emptyList(),
  public val type: HciSubscrChannelType = HciSubscrChannelType.UNDEF
)
