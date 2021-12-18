package de.jlnstrk.transit.client.hci.method.locsearch

import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@Serializable
public data class HciLocSearchResult(
    public val locL: List<HciLocation> = emptyList(),
) : HciServiceResult()