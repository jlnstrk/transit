package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Boolean
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyTransitStatus(
  public val GU: Boolean = false,
  public val allRt: Boolean = false,
  public val departed: Boolean = false,
  public val garant: Boolean = false,
  public val msgL: List<HciMessage> = emptyList(),
  public val need: Boolean = false,
  public val noNeed: Boolean = false,
  public val noWait: Boolean = false,
  public val nonGarant: Boolean = false,
  public val notToRule: Boolean = false,
  public val rtOk: Boolean = false,
  public val sollOk: Boolean = false,
  public val theoOk: Boolean = false,
  public val toRule: Boolean = false,
  public val trackChange: Boolean = false,
  public val useWalk: Boolean = false,
  public val waitExists: Boolean = false,
  public val wruleExists: Boolean = false
)
