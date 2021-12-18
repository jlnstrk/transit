package de.jlnstrk.transit.client.hci.method.locmatch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocationMatch
import de.jlnstrk.transit.client.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocMatchResult(
    public val match: HciLocationMatch,
) : HciServiceResult()