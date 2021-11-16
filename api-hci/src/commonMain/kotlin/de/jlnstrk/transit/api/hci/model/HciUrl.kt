package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciUrl(
    /** The actual URL string */
    public val url: String,

    /** The label for this URL */
    public val label: String?
)