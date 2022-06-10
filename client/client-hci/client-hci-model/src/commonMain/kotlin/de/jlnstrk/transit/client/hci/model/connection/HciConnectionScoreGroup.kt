package de.jlnstrk.transit.client.hci.model.connection

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciConnectionScoreGroup(
  public val bitmask: Int? = null,
  public val grpid: String,
  public val icoX: Int? = null,
  public val initScoringType: HciConnectionScoringType,
  public val name: String? = null,
  public val conScoringL: List<HciConnectionScoring> = emptyList(),
  public val msgL: List<HciMessage> = emptyList(),
  public val requests: List<HciConnectionGroupRequest> = emptyList(),
  public val subL: List<HciConnectionScoreGroup> = emptyList(),
  public val scrollable: Boolean = false,
)
