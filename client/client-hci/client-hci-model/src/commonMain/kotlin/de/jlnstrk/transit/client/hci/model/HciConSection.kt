package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.gis.HciGisRoute
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyStop
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import de.jlnstrk.transit.client.hci.model.recon.HciReconstructionState
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciConSection(
  public val arr: HciJourneyStop? = null,
  public val chg: HciChange? = null,
  public val dep: HciJourneyStop? = null,
  public val gis: HciGisRoute? = null,
  public val hide: Boolean = false,
  public val isPref: Boolean = false,
  public val jny: HciJourney? = null,
  public val minChg: String? = null,
  public val preEdgeId: String? = null,
  public val preNodeId: String? = null,
  public val recState: HciReconstructionState? = null,
  public val type: HciConSectionType? = null,
  public val childSecL: List<HciConSection> = emptyList(),
  public val errL: List<HciConSectionErrorType> = emptyList(),
  public val msgL: List<HciMessage> = emptyList(),
  public val parJnyL: List<HciJourney> = emptyList(),
  public val resRecommendation: HciReservationRecommendation = HciReservationRecommendation.U,
  public val resState: HciReservationState = HciReservationState.U,
)
