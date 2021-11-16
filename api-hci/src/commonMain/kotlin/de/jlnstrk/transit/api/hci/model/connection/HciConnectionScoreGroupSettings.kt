package de.jlnstrk.transit.api.hci.model.connection

import kotlinx.serialization.Serializable

@Serializable
public data class HciConnectionScoreGroupSettings(
    public val conGrpL: List<HciConnectionScoreGroup>,
    public val selectL: List<Select>,
    public val variant: Variant,
) {

    @Serializable
    public data class Select(
        public val icoX: Int,

        public val name: String,

        public val bitIdx: Int
    )

    @Serializable
    public enum class Variant {
        RADIO
    }
}