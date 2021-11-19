package de.jlnstrk.transit.api.hci.model.eco

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciEco(
    public val co2: Double?,
    public val co2f: Double?,
    public val dist: Int?,
    public val mmhc: Double?,
    public val nox: Double?,
    public val part: Double?,
    public val part10: Double?,
    public val partV: Double?,
    public val primef: Double?,
    public val rating: Int?,
    public val so2: Double?,
    public val type: CarrierType,
    public val ubp: Double?,
) {

    @HciModel("1.39")
    @Serializable
    public enum class CarrierType {
        // TODO: Meaning?
        BEE,

        // TODO: Meaning?
        PFT,

        // TODO: Meaning?
        PRT,

        // TODO: Meaning?
        PUT,
    }
}