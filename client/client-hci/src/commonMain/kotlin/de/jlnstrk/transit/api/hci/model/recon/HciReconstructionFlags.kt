package de.jlnstrk.transit.api.hci.model.recon

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciReconstructionFlags(
    public val acceptGaps: Boolean,
    public val allowDisabledStops: Boolean,
    public val flagAllNonReachable: Boolean,
    public val matchCatStrict: Boolean,
    public val matchIdStrict: Boolean,
    public val matchNumStrict: Boolean,
    public val matchRtType: Boolean,
    public val matchIdNonBlank: Boolean?,
)