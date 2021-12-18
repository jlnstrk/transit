package de.jlnstrk.transit.client.hci.request

import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import de.jlnstrk.transit.client.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@Serializable
public abstract class HciServiceRequest<Res : HciServiceResult> {
    internal abstract val method: HciServiceMethod
}