package de.jlnstrk.transit.interop

import de.jlnstrk.transit.common.CompositeProvider
import de.jlnstrk.transit.common.Provider
import de.jlnstrk.transit.common.extensions.use
import de.jlnstrk.transit.common.service.StationBoardService
import de.jlnstrk.transit.common.service.TripSearchService
import kotlinx.datetime.FixedOffsetTimeZone
import kotlinx.datetime.TimeZone
import kotlinx.datetime.UtcOffset


class CompositeProviderTest {

    fun usesCorrectServices() {
        val efaProvider = object : Provider.Implementation() {
            override val timezone: TimeZone
                get() = FixedOffsetTimeZone(UtcOffset.ZERO)
        }

        val composite = CompositeProvider {
            use<StationBoardService>(from = efaProvider)
            use<TripSearchService>(from = efaProvider)
        }
    }
}