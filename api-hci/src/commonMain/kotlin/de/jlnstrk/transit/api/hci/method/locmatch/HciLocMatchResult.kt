package de.jlnstrk.transit.api.hci.method.locmatch

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.location.HciLocationMatch
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocMatchResult(
    public val match: HciLocationMatch,
) : HciServiceResult()