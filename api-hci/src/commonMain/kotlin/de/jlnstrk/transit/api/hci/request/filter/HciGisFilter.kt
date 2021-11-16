package de.jlnstrk.transit.api.hci.request.filter

import de.jlnstrk.transit.api.hci.model.gis.HciGisProfile
import kotlinx.serialization.Serializable

@Serializable
public data class HciGisFilter(
    public val type: Type,
    public val mode: HciRequestFilterMode,
    public val profile: HciGisProfile? = null,
    public val meta: String? = null,
) {

    @Serializable
    public enum class Type {
        // TODO: Meaning?
        M,

        // TODO: Meaning?
        P,
        PRM_NONE,
        PRM_PRESELECT,

        // TODO: Meaning?
        U,
    }

    @Serializable
    public enum class Mode {
        // TODO: Meaning?
        B,

        // TODO: Meaning?
        F,

        // TODO: Meaning?
        FB,

        // TODO: Meaning?
        FBT,

        // TODO: Meaning?
        T,

        // TODO: Meaning?
        U
    }
}