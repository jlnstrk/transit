package de.jlnstrk.transit.client.hci.model.booking

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciOperatorShare
import de.jlnstrk.transit.client.hci.model.HciSpatialFareValidity
import de.jlnstrk.transit.client.hci.model.HciTemporalFareValidity
import de.jlnstrk.transit.client.hci.model.fare.HciFarePrice
import de.jlnstrk.transit.client.hci.model.fare.HciFareProperties
import de.jlnstrk.transit.client.hci.model.fare.HciFareToken
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciBookingObj(
  public val CS: String? = null,
  public val CT: Int? = null,
  public val DV: Int? = null,
  public val FO: Int? = null,
  public val FP: HciFareProperties? = null,
  public val FS: String? = null,
  public val LVL: Int? = null,
  public val P: String? = null,
  public val PCR: String? = null,
  public val PRC: HciFarePrice? = null,
  public val PRD: Int? = null,
  public val SV: HciSpatialFareValidity? = null,
  public val TK: HciFareToken? = null,
  public val TV: HciTemporalFareValidity? = null,
  public val VT: String? = null,
  public val CLD: List<HciOperatorShare> = emptyList(),
  public val FD: Int = -1,
  public val FF: Boolean = true,
  public val NUM: Int = 1,
)
