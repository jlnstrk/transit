package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRect
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciMapLayer(
  public val attrb: String? = null,
  public val extent: HciGeoRect? = null,
  public val icoX: Int? = null,
  public val id: String,
  public val initBBox: HciGeoRect? = null,
  public val lbl: String? = null,
  public val type: String? = null,
  public val url: String? = null,
  public val subd: List<String> = emptyList(),
  public val alpha: Int = -1,
  public val proj: HciMapLayerProjection = HciMapLayerProjection.U,
  public val zoomMax: Int = -1,
  public val zoomMin: Int = -1,
)
