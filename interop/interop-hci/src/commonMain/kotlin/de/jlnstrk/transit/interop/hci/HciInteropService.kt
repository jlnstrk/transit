package de.jlnstrk.transit.interop.hci

import de.jlnstrk.transit.api.hci.HciConsumer
import de.jlnstrk.transit.api.hci.model.HciCommon
import de.jlnstrk.transit.common.Service
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal abstract class HciInteropService(
    provider: HciProvider,
    protected val consumer: HciConsumer
) : Service.Implementation<HciProvider>(provider) {

    protected inline fun <T> withCommon(
        common: HciCommon,
        block: HciCommonContext.() -> T
    ): T {
        val scope = HciCommonContext(provider, common)
        return scope.block()
    }
}