package de.jlnstrk.transit.client.hci.request

import de.jlnstrk.transit.client.hci.HciAuth
import de.jlnstrk.transit.client.hci.HciClient
import de.jlnstrk.transit.client.hci.serializer.HciRequestEnvelopeSerializer
import kotlinx.serialization.Serializable

@Serializable
public data class HciRequest(
    /** The requesting client */
    public val client: HciClient,
    /** The authentication for the request */
    public val auth: HciAuth?,
    /** The HCI ext of the client */
    public val ext: String?,
    /** The client HCI version */
    public val ver: String,
    /** The client language */
    public val lang: String,
    /** The service request frames */
    public val svcReqL: List<@Serializable(with = HciRequestEnvelopeSerializer::class) HciRequestEnvelope> = emptyList()
)