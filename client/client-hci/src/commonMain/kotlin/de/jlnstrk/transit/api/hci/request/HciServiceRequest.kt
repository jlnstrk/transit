package de.jlnstrk.transit.api.hci.request

import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@Serializable
public abstract class HciServiceRequest<Res : HciServiceResult> {
    internal abstract val method: HciServiceMethod
}