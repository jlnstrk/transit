package de.jlnstrk.transit.client.hci.model.gis

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGisProfile(
  public val attrExcl: String? = null,
  public val attrIncl: String? = null,
  public val checkInTime: Int = 0,
  public val checkOutTime: Int = 0,
  public val cost: Int? = null,
  public val durationOfStay: Int? = null,
  public val ellipsePercentage: Int? = null,
  public val enabled: Boolean? = null,
  public val geometry: Int? = null,
  public val linDistRouting: Boolean? = null,
  public val maxdist: Int? = null,
  public val maxdur: Int? = null,
  public val mindist: Int? = null,
  public val opt: Int? = null,
  public val productBitmask: Int? = null,
  public val router: String? = null,
  public val speed: Int? = null,
  public val type: HciGisType,
  public val waittime: Int? = null,
)
