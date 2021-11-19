package de.jlnstrk.transit.api.hci.model.tariff

import kotlinx.serialization.Serializable

@Serializable
public data class HciTariffTravellerProfile(
    public val age: Int? = null,
    public val disabledType: DisabledType? = null,
    public val redtnCard: Int? = null,
    public val ticketType: HciTariffTravellerTicketType? = null,
    public val type: Type? = null,
) {

    @Serializable
    public enum class DisabledType {
        // TODO: Meaning?
        NH,

        // TODO: Meaning?
        WH,
    }

    @Serializable
    public enum class Type {
        // TODO: Meaning?
        B,

        // TODO: Meaning?
        E,

        // TODO: Meaning?
        K,

        // TODO: Meaning?
        R,

        // TODO: Meaning?
        S
    }
}