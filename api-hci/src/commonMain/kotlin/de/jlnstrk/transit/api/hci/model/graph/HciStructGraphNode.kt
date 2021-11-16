package de.jlnstrk.transit.api.hci.model.graph

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.geo.HciCoord
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciStructGraphNode(
    public val id: String?,
    public val mainNodeX: Int?,
    public val type: Type?,
    public val coord: HciCoord?,
    public val locX: Int?,
) {

    @HciModel("1.39")
    @Serializable
    public enum class Type {
        INTERMEDIATE,
        STATION,
        UNDEF
    }
}