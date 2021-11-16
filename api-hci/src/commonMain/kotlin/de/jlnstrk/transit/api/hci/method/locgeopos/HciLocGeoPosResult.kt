package de.jlnstrk.transit.api.hci.method.locgeopos

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciEventLocation
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocGeoPosResult(
    public val locL: List<HciLocation> = emptyList(),
    public val evtLocL: List<HciEventLocation> = emptyList(),
) : HciServiceResult()