package de.jlnstrk.transit.client.hci.method.locwalkdetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciLocationWalk
import de.jlnstrk.transit.client.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocWalkDetailsResult(
    public val locWalkL: List<HciLocationWalk> = emptyList(),
) : HciServiceResult()