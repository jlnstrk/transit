package de.jlnstrk.transit.api.hci.model.tariff

import kotlinx.serialization.Serializable

@Serializable
public enum class HciTariffTravellerType {
    ADULT,
    BIKE,
    CHILD,
    DISABLED,
    GROUP,
    SENIOR,
    YOUTH,
}