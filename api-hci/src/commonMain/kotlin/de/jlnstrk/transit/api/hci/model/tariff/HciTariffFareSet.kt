package de.jlnstrk.transit.api.hci.model.tariff

import de.jlnstrk.transit.api.hci.model.message.HciMessage
import kotlinx.serialization.Serializable

@Serializable
public data class HciTariffFareSet(
    public val addData: String?,
    public val desc: String?,
    public val fSecRefX: Int?,
    public val fStopRefX: Int?,
    public val fareL: List<HciTariffFare> = emptyList(),
    public val icoX: Int?,
    public val msgL: List<HciMessage> = emptyList(),
    public val name: String?,
    public val tSecRefX: Int?,
    public val tStopRefX: Int?,
    public val urlX: Int?,
)