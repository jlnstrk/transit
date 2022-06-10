package de.jlnstrk.transit.client.hci.model.eco

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Double
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciEco(
  public val co2: Double? = null,
  public val co2el: Double = 0.000000,
  public val co2f: Double = 0.000000,
  public val nmhc: Double = 0.000000,
  public val nmvoc: Double = 0.000000,
  public val nox: Double = 0.000000,
  public val part: Double = 0.000000,
  public val part10: Double = 0.000000,
  public val partV: Double = 0.000000,
  public val prime: Double = 0.000000,
  public val primeEnergy: Double = 0.000000,
  public val primef: Double = 0.000000,
  public val rating: Int? = null,
  public val so2: Double = 0.000000,
  public val ubp: Double = 0.000000,
  public val ubp13: Double = 0.000000,
  public val dist: Int = -1,
  public val type: HciEcoCarrierType = HciEcoCarrierType.PUT,
)
