package de.jlnstrk.transit.api.hci.model.tariff

import kotlinx.serialization.Serializable

@Serializable
public data class HciTariffReference(
    public val fareSetX: Int,
    public val fareX: Int?,
    public val ticketX: Int?,
    public val type: Type
) {

    @Serializable
    public enum class Type {
        // TODO: Meaning?
        F,

        // TODO: Meaning?
        FS,

        // TODO: Meaning?
        T
    }
}