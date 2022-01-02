package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.gis.HciGisRoutingErrorType
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciPreselectionEdge(
  public val cost: Int? = null,
  public val dist: Int? = null,
  public val dur: String? = null,
  public val err: HciGisRoutingErrorType? = null,
  public val id: String? = null,
  public val speed: Int? = null,
  public val `value`: Int? = null
)
