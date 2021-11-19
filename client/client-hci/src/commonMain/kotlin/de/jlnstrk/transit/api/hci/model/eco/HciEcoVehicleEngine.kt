package de.jlnstrk.transit.api.hci.model.eco

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciEcoVehicleEngine {
    @SerialName("avg")
    AVG,

    @SerialName("diesel_conv")
    DIESEL_CONV,

    @SerialName("diesel_euro1")
    DIESEL_EURO_1,

    @SerialName("diesel_euro2")
    DIESEL_EURO_2,

    @SerialName("diesel_euro3")
    DIESEL_EURO_3,

    @SerialName("diesel_euro4")
    DIESEL_EURO_4,

    @SerialName("diesel_euro5")
    DIESEL_EURO_5,

    @SerialName("diesel_euro6")
    DIESEL_EURO_6,

    @SerialName("electric")
    ELECTRIC,

    @SerialName("gas_conv")
    GAS_CONV,

    @SerialName("gas_euro1")
    GAS_EURO_1,

    @SerialName("gas_euro2")
    GAS_EURO_2,

    @SerialName("gas_euro3")
    GAS_EURO_3,

    @SerialName("gas_euro4")
    GAS_EURO_4,

    @SerialName("gas_euro5")
    GAS_EURO_5,

    @SerialName("gas_euro6")
    GAS_EURO_6,

    @SerialName("hybrid")
    HYBRID,

    @SerialName("lpg_conv")
    LPG_CONV,

    @SerialName("lpg_euro1")
    LPG_EURO_1,

    @SerialName("lpg_euro2")
    LPG_EURO_2,

    @SerialName("lpg_euro3")
    LPG_EURO_3,

    @SerialName("lpg_euro4")
    LPG_EURO_4,

    @SerialName("lpg_euro5")
    LPG_EURO_5,

    @SerialName("lpg_euro6")
    LPG_EURO_6,
}