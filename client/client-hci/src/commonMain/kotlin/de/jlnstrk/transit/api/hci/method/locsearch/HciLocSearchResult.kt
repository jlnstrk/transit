package de.jlnstrk.transit.api.hci.method.locsearch

import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@Serializable
public data class HciLocSearchResult(
    public val locL: List<HciLocation> = emptyList(),
) : HciServiceResult()