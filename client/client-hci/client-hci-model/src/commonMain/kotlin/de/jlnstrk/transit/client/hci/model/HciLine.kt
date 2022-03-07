package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLine(
  public val lineId: String? = null,
  public val locX: Int? = null,
  public val prodX: Int? = null,
  public val regS: String? = null,
  public val dirRefL: List<Int> = emptyList(),
  public val jnyL: List<HciJourney> = emptyList(),
  public val locStartEndRefL: List<Int> = emptyList(),
  public val locStopRefL: List<Int> = emptyList(),
  public val prodGraphL: List<HciProductGraph> = emptyList()
)
