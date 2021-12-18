package de.jlnstrk.transit.client.hci.method.locgeoreach

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciReachPosition
import de.jlnstrk.transit.client.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocGeoReachResult(
    public val mapLayX: Int? = null,
    public val posL: List<HciReachPosition> = emptyList(),
) : HciServiceResult()