package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciRequestParameterGroup(
    public val meth: HciServiceMethod,
    public val type: Type,
    public val elmX: Int?,
) {

    @HciModel("1.39")
    @Serializable
    public enum class Type {
        BAIM,
        HIDDEN,
    }
}