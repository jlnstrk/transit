package de.jlnstrk.transit.api.hci.model.tariff

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class HciTariffReductionCard {
    ABO_FLEX,

    @SerialName("BC25")
    BC_25,

    @SerialName("BC25F")
    BC_25_F,

    @SerialName("BC50")
    BC_50,

    @SerialName("BC50F")
    BC_50_F,

    HALBTAX,
    NONE,
    SHCARD,
}