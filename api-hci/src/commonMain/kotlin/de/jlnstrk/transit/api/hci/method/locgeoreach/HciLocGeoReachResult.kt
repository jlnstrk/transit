package de.jlnstrk.transit.api.hci.method.locgeoreach

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciReachPosition
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocGeoReachResult(
    public val mapLayX: Int? = null,
    public val posL: List<HciReachPosition> = emptyList(),
) : HciServiceResult()