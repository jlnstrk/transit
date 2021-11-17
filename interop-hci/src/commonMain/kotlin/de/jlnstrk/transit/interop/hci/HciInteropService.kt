package de.jlnstrk.transit.interop.hci

import de.jlnstrk.transit.api.hci.HciConsumer
import de.jlnstrk.transit.api.hci.model.HciCommon
import de.jlnstrk.transit.util.Service

internal abstract class HciInteropService(
    provider: HciProvider,
    protected val endpoint: HciConsumer
) : Service.Base<HciProvider>(provider) {

    protected inline fun <T> withCommon(
        common: HciCommon,
        block: HciCommonContext.() -> T
    ): T {
        val scope = HciCommonContext(provider, common)
        return scope.block()
    }
}