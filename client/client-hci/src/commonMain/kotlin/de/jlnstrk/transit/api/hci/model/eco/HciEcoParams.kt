package de.jlnstrk.transit.api.hci.model.eco

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciEcoParams(
    public val airFleet: HciEcoAircraftFleet?,
    public val elSrc: HciEcoElectricitySource,
    public val fltFeeder: HciEcoFlightFeeder,
    public val fltLoad: HciEcoFlightLoad,
    public val vhclCls: HciEcoVehicleClass,
    public val vhclEng: HciEcoVehicleEngine,
    public val vhclLoad: HciEcoVehicleLoad,
    public val car: Boolean,
    public val flt: Boolean,
    public val optCarST: Boolean,
)