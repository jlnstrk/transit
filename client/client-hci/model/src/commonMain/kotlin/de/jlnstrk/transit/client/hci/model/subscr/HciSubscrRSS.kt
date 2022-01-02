package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrRSS(
  public val rssAddress: String,
  public val serviceDays: HciSubscrDays? = null
)
