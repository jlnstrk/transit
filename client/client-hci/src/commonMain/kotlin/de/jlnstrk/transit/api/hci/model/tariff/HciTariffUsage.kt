package de.jlnstrk.transit.api.hci.model.tariff

import kotlinx.serialization.Serializable

@Serializable
public enum class HciTariffUsage {
    ANY,
    MULTI,
    ONEWAY,
    PERIOD,
    POSTPAID,
    RETURN,
    SUBSCR,
}