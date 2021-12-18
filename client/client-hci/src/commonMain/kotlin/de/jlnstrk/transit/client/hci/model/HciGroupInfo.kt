package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciGroupInfo(
    public val fds: List<HciGroup> = emptyList(),
    public val fqs: List<HciGroup> = emptyList(),
    public val pds: List<HciGroup> = emptyList(),
    public val pqs: List<HciGroup> = emptyList(),
)