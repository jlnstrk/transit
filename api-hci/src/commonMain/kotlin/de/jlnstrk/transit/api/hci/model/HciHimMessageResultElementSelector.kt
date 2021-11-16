package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciHimMessageResultElementSelector {
    ALL,
    BASIC,
    BASIC_WITH_MOD_TIMESTAMP,
}