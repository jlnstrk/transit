package de.jlnstrk.transit.api.hci.response

import de.jlnstrk.transit.api.hci.model.HciCommon
import kotlinx.serialization.Serializable

@Serializable
public abstract class HciServiceResult {
    public var common: HciCommon = HciCommon()
        private set
}