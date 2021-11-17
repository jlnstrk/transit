package de.jlnstrk.transit.interop

import de.jlnstrk.transit.common.CompositeProvider
import de.jlnstrk.transit.common.Provider
import de.jlnstrk.transit.common.extensions.use
import de.jlnstrk.transit.common.service.StationBoardService
import de.jlnstrk.transit.common.service.TripSearchService
import de.jlnstrk.transit.util.ZoneOffset


class CompositeProviderTest {

    fun usesCorrectServices() {
        val efaProvider = object : Provider.Implementation() {
            override val timezone: ZoneOffset
                get() = ZoneOffset(0.0)
        }

        val composite = CompositeProvider {
            use<StationBoardService>(from = efaProvider)
            use<TripSearchService>(from = efaProvider)
        }
    }
}