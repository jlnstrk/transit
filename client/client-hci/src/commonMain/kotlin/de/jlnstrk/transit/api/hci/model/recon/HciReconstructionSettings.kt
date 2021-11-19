package de.jlnstrk.transit.api.hci.model.recon

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciReconstructionSettings(
    public val flags: HciReconstructionFlags?,
    public val times: HciReconstructionTimeDeviation?,
    public val useCombinedComparison: Boolean?,
)