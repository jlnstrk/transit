package de.jlnstrk.transit.api.hci.model.recon

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.base.HciLocalTime
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciReconstructionSectionData(
    public val depLoc: HciLocation,
    public val arrLoc: HciLocation,
    public val dTimeS: HciLocalTime?,
    public val dTimeR: HciLocalTime?,
    public val aTimeS: HciLocalTime?,
    public val aTimeR: HciLocalTime?,
    public val trainCategory: String?,
    public val trainName: String?,
    public val trainNumber: String?,
    public val type: HciReconstructionSectionType?,
)