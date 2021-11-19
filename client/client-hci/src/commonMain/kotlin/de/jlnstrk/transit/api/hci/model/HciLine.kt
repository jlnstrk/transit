package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.journey.HciJourney
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciLine(
    public val lineId: String?,
    public val regS: String?,
    public val prodX: Int?,
    public val locX: Int?,
    public val dirRefL: List<Int> = emptyList(),
    public val jnyL: List<HciJourney> = emptyList(),
    public val locStartEndRefL: List<Int> = emptyList(),
    public val locStopRefL: List<Int> = emptyList(),
    public val prodGraphL: List<HciProductGraph> = emptyList(),
)
