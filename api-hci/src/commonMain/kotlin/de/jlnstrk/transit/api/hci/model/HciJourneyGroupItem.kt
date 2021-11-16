package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciJourneyGroupItem(
    public val jnyRef: Int,
    public val icoX: Int?,
    public val msgL: List<HciMessage> = emptyList(),
)