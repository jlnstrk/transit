package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciExternalContent(
    public val content: HciContent?,
    public val contentAlt: List<HciContent> = emptyList(),
    public val iconX: Int?,
    public val provider: String?,
    public val providerName: String?,
    public val text: String?,
    public val textS: String?,
)