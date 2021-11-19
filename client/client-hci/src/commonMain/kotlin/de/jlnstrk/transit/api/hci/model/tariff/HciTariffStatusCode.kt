package de.jlnstrk.transit.api.hci.model.tariff

import kotlinx.serialization.Serializable

@Serializable
public enum class HciTariffStatusCode {
    NA,
    OFF,
    OK,
    RELOAD
}