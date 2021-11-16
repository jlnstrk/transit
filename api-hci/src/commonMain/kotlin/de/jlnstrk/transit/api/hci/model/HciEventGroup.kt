package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciEventGroup(
    public val id: String?,
    public val name: String?,
    public val icoX: Int?,
)