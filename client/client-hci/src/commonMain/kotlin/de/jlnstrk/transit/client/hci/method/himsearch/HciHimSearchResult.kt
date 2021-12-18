package de.jlnstrk.transit.client.hci.method.himsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.him.HciHimMessage
import de.jlnstrk.transit.client.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciHimSearchResult(
    public val msgL: List<HciHimMessage> = emptyList()
) : HciServiceResult()