package de.jlnstrk.transit.client.hci.model.gis

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciPolylineGroup
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import de.jlnstrk.transit.client.hci.serializer.HciDurationSerializer
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.time.Duration
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGisRoute(
  public val aZId: String? = null,
  public val aZName: String? = null,
  public val aZUrl: String? = null,
  public val ctx: String? = null,
  public val dZId: String? = null,
  public val dZName: String? = null,
  public val dZUrl: String? = null,
  public val dirTxt: String? = null,
  public val dist: Int? = null,
  @Serializable(with = HciDurationSerializer::class)
  public val durR: Duration? = null,
  @Serializable(with = HciDurationSerializer::class)
  public val durS: Duration? = null,
  @Serializable(with = HciDurationSerializer::class)
  public val durST: Duration? = null,
  @Serializable(with = HciDurationSerializer::class)
  public val durW2C: Duration? = null,
  @Serializable(with = HciDurationSerializer::class)
  public val durW2D: Duration? = null,
  public val edgeHashR: String? = null,
  public val edgeHashS: String? = null,
  public val getDescr: Boolean = true,
  public val getPoly: Boolean = true,
  public val gisPrvrCtx: String? = null,
  public val maxAlt: Int? = null,
  public val maxNegSlope: Int? = null,
  public val maxPosSlope: Int? = null,
  public val minAlt: Int? = null,
  public val negAlt: Int? = null,
  public val polyG: HciPolylineGroup? = null,
  public val posAlt: Int? = null,
  public val prodX: Int? = null,
  public val prvX: Int? = null,
  public val resLDrawStyleX: Int? = null,
  public val sumLDrawStyleX: Int? = null,
  public val msgL: List<HciMessage> = emptyList(),
  public val rRefL: List<Int> = emptyList(),
  public val segL: List<HciGisRouteSegment> = emptyList(),
  public val dirGeo: Int = 0,
  public val gisPrvr: HciGisProvider = HciGisProvider.U,
  public val hasImpRem: Boolean = false,
)
