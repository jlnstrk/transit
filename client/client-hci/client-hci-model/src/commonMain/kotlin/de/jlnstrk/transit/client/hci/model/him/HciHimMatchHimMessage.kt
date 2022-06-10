package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceDays
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMatchHimMessage(
  public val cDays: HciServiceDays? = null,
  public val hid: String,
  public val msgSrc: String? = null,
  public val vDays: HciServiceDays? = null,
)
