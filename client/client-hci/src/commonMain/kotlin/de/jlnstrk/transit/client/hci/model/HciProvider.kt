package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciProvider(
    public val id: String?,
    public val name: String?,
    public val region: String?,
    public val extCont: HciExternalContent?,
)