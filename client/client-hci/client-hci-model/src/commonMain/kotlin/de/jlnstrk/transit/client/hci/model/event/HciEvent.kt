package de.jlnstrk.transit.client.hci.model.event

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciEvent(
  public val catOut: String,
  public val desc: String? = null,
  public val descAdd: String? = null,
  public val extEvtId: String,
  public val groupid: String? = null,
  public val icoX: Int? = null,
  public val name: String,
  public val urlX: Int? = null,
  public val webview: String? = null,
  public val msgL: List<HciMessage> = emptyList(),
  public val free: Boolean = false,
)
