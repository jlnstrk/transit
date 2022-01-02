package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrEventHIM(
  public val cat: Int? = null,
  public val content: String? = null,
  public val extId: String? = null,
  public val id: String,
  public val received: String? = null,
  public val title: String? = null,
  public val updated: Boolean = false
)
