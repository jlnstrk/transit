package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciGroupInfo(
    public val fds: List<HciGroup> = emptyList(),
    public val fqs: List<HciGroup> = emptyList(),
    public val pds: List<HciGroup> = emptyList(),
    public val pqs: List<HciGroup> = emptyList(),
)