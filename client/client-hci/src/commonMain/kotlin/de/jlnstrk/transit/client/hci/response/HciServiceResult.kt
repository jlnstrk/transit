package de.jlnstrk.transit.client.hci.response

import de.jlnstrk.transit.client.hci.model.HciCommon
import kotlinx.serialization.Serializable

@Serializable
public abstract class HciServiceResult {
    public var common: HciCommon = HciCommon()
        private set
}