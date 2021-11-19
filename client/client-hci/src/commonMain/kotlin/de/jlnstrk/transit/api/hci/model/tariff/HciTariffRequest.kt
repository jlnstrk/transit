package de.jlnstrk.transit.api.hci.model.tariff

import kotlinx.serialization.Serializable

@Serializable
public class HciTariffRequest(
    public val cId: String? = null,
    public val cType: HciTariffCustomerType? = null,
    public val jnyCl: Int? = null,
    public val rType: Type? = null,
    public val tarMode: String? = null,
    public val tixCheck: Boolean? = null,
    public val tixList: List<HciTariffTicket> = emptyList(),
    public val tvlrProf: List<HciTariffTravellerProfile> = emptyList(),
    public val tvlrProfData: String? = null,
) {

    @Serializable
    public enum class Type {
        FULL,
        MIN
    }
}