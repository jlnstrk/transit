package de.jlnstrk.transit.api.hci.model.location

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciLocationMatch(
    public val field: HciLocationField?,
    public val state: State?,
    public val locL: List<HciLocation> = emptyList(),
) {

    @HciModel("1.39")
    @Serializable
    public enum class State {
        // TODO: Meaning?
        F,

        // TODO: Meaning?
        I,

        // TODO: Meaning?
        L,

        // TODO: Meaning?
        M,

        // TODO: Meaning?
        U,
    }
}