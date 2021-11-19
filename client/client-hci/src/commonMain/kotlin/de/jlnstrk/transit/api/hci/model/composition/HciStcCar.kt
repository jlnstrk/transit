package de.jlnstrk.transit.api.hci.model.composition

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciStcCar(
    public val number: String?,
    public val sect: String?,
    public val type: Int?,
    public val attrL: List<HciTrainComposition.Attribute> = emptyList(),
)