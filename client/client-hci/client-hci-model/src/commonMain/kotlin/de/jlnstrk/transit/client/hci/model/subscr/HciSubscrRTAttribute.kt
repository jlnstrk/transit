package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrRTAttribute(
  public val code: String,
  public val isActivated: Boolean,
  public val isDeactivated: Boolean,
  public val name: String? = null,
)
