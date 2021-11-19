package de.jlnstrk.transit.api.hci.model.connection

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciConnectionScoreGroupSelection(
    public val bitIdx: Int?,
    public val icoX: Int?,
    public val name: String?,
) {

    @HciModel("1.39")
    @Serializable
    public enum class Variant {
        CHECKBOX,
        RADIO,
    }
}