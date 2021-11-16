package de.jlnstrk.transit.api.hci.model.tariff

import kotlinx.serialization.Serializable

@Serializable
public enum class HciTariffTravellerTicketType {
    SHORT,
    SINGLE,
    DAILY,
}