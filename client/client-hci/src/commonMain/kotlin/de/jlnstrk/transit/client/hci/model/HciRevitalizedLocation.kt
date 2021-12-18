package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciRevitalizedLocation(
    public val eteId: String?,
    public val loc: HciLocation?,
    public val state: State?,
) {

    @HciModel("1.39")
    @Serializable
    public enum class State {
        // TODO: Meaning?
        BR,

        // TODO: Meaning?
        FK,

        // TODO: Meaning?
        UP,

        // TODO: Meaning?
        VA
    }
}