package de.jlnstrk.transit.api.hci.model.him

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciHimMessageCategory(
    /** The id of this message category */
    public val id: Int,
    /** The name of this message category */
    public val name: String?
)