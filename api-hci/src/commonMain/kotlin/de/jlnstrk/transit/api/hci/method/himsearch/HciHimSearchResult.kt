package de.jlnstrk.transit.api.hci.method.himsearch

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.him.HciHimMessage
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciHimSearchResult(
    public val msgL: List<HciHimMessage> = emptyList()
) : HciServiceResult()