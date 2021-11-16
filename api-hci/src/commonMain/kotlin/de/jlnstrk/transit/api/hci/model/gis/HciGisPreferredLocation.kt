package de.jlnstrk.transit.api.hci.model.gis

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciGisPreferredLocation(
    public val type: HciGis.Type,
    public val dLoc: HciLocation?,
    public val sLoc: HciLocation?,
)