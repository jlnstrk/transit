package de.jlnstrk.transit.client.hapi.response.base

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.HapiPair
import de.jlnstrk.transit.client.hapi.serializer.HapiListUnwrapSerializer
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public abstract class HapiResponse {
    @Serializable(with = HapiListUnwrapSerializer::class)
    public val TechnicalMessages: List<HapiPair> = emptyList()
    public val serverVersion: String? = null
    public val dialectVersion: String? = null
    public val version: String? = null

    // TODO: Format?
    public val planRtTs: Long? = null
    public val errorCode: String? = null
    public val errorText: String? = null
    public val requestId: String? = null
}