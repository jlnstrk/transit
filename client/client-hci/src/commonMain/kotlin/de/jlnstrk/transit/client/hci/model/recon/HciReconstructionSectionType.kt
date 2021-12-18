package de.jlnstrk.transit.client.hci.model.recon

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciReconstructionSectionType {
    DEVI,
    GIS_BIKE,
    GIS_FOOT,
    GIS_KISS,
    GIS_PARK,
    GIS_TAXI,
    JNY,
    TRSF,
    WALK,
}