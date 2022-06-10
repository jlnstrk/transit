package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrResultCon(
  public val channels: List<HciSubscrChannel> = emptyList(),
  public val ctxRecon: String? = null,
  public val language: String? = null,
  public val status: HciSubscrStatus,
  public val subscrId: Int,
)
