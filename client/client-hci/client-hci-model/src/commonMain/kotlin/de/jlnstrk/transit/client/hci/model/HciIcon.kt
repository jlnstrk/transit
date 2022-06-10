package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciIcon(
  public val bg: HciColor? = null,
  public val brd: HciColor? = null,
  public val fg: HciColor? = null,
  public val res: String? = null,
  public val shpRes: String? = null,
  public val txt: String? = null,
  public val txtA: String? = null,
  public val txtS: String? = null,
  public val zIdx: Int? = null,
  public val shp: HciShapeType = HciShapeType.U,
  public val sty: HciStyleType = HciStyleType.U,
)
