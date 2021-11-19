package de.jlnstrk.transit.api.hci.model.recon

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciReconstructionTimeDeviation(
    public val depL: Int?,
    public val depU: Int?,
    public val arrL: Int?,
    public val arrU: Int?,
)