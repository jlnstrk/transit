package de.jlnstrk.transit.client.hci.model.geo

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import de.jlnstrk.transit.client.hci.model.HciDateTimeInterval
import de.jlnstrk.transit.client.hci.model.HciPolyline
import de.jlnstrk.transit.client.hci.model.HciProvider
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGeoFeature(
  public val externalID: String? = null,
  public val icoX: Int? = null,
  public val id: String,
  public val provider: HciProvider? = null,
  public val subType: String? = null,
  public val title: String? = null,
  public val type: HciGeoFeatureType,
  public val geoDataXL: List<Int> = emptyList(),
  public val lines: List<HciPolyline> = emptyList(),
  public val msgL: List<HciMessage> = emptyList(),
  public val points: List<HciCoord> = emptyList(),
  public val validityList: List<HciDateTimeInterval> = emptyList()
)
