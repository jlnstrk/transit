package de.jlnstrk.transit.client.hci.model.eco

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciEcoParams(
  public val car: Boolean = true,
  public val flt: Boolean = true,
  public val airFleet: HciEcoAircraftFleet = HciEcoAircraftFleet.AVG,
  public val elSrc: HciEcoElectricitySource = HciEcoElectricitySource.STD,
  public val euroNorm: HciEcoEuroNorm = HciEcoEuroNorm.AVG,
  public val fltFeed: HciEcoFlightFeeder = HciEcoFlightFeeder.BOTH,
  public val fltLoad: HciEcoFltLoad = HciEcoFltLoad.AVG,
  public val fuelType: HciEcoFuelType = HciEcoFuelType.AVG,
  public val load: HciEcoLoad = HciEcoLoad.AVG,
  public val optCarST: Boolean = false,
  public val ptLoad: HciEcoPTLoad = HciEcoPTLoad.AVG,
  public val relConsumption: Int = 100,
  public val relVhclWeight: Int = 100,
  public val vhclCls: HciEcoVehicleClass = HciEcoVehicleClass.MEDIUM,
  public val vhclEng: HciEcoVehicleEngine = HciEcoVehicleEngine.GAS_CONV,
  public val vhclLoad: HciEcoVehicleLoad = HciEcoVehicleLoad.AVG
)
