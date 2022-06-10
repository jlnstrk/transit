package de.jlnstrk.transit.client.hci.model.gis

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGisRouteSegment(
  public val dirTx: String? = null,
  public val icoX: Int? = null,
  public val manTx: String? = null,
  public val name: String? = null,
  public val polyE: Int? = null,
  public val polyS: Int? = null,
  public val rNum: String? = null,
  public val targetName: String? = null,
  public val edgeL: List<HciGisEdge> = emptyList(),
  public val msgL: List<HciMessage> = emptyList(),
  public val rRefL: List<Int> = emptyList(),
  public val dist: Int = -1,
  public val man: HciGisManoeuvre = HciGisManoeuvre.NO,
  public val ori: HciGisOrientation = HciGisOrientation.U,
  public val rType: HciGisRoadType = HciGisRoadType.U,
)
