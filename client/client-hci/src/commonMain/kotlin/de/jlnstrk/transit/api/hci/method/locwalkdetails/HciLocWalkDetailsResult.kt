package de.jlnstrk.transit.api.hci.method.locwalkdetails

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciLocationWalk
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocWalkDetailsResult(
    public val locWalkL: List<HciLocationWalk> = emptyList(),
) : HciServiceResult()