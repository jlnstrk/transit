package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciPolyline(
  public val crdEncDist: String? = null,
  public val crdEncF: String? = null,
  public val crdEncS: String? = null,
  public val crdEncYX: String? = null,
  public val crdEncZ: String? = null,
  public val delta: Boolean,
  public val lDrawStyleX: Int? = null,
  public val annoL: List<HciAnnotationSegment> = emptyList(),
  public val crdNumL: List<Int> = emptyList(),
  public val ppLocRefL: List<HciPolyPointLocationRef> = emptyList(),
  public val dim: Int = 2,
  public val crd: List<Double> = emptyList()
)
