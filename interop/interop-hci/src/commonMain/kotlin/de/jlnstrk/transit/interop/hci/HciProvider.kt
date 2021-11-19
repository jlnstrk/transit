package de.jlnstrk.transit.interop.hci

import de.jlnstrk.transit.api.hci.HciConfig
import de.jlnstrk.transit.api.hci.HciConsumer
import de.jlnstrk.transit.common.Provider
import de.jlnstrk.transit.common.service.*
import de.jlnstrk.transit.interop.hafas.HafasClassMapping
import de.jlnstrk.transit.interop.hci.service.*
import de.jlnstrk.transit.util.LocalDateTime
import de.jlnstrk.transit.util.ZoneOffset

public abstract class HciProvider : Provider.Implementation(), HafasClassMapping {
    override val timezone: ZoneOffset get() = ZoneOffset.local(LocalDateTime.now())
    public abstract val config: HciConfig

    init {
        val consumer by lazy { HciConsumer(config) }
        registerService<LocationSearchService> { HciLocationSearchService(this, consumer) }
        registerService<NearbyLocationsService> { HciNearbyLocationsService(this, consumer) }
        registerService<StationBoardService> { HciStationBoardService(this, consumer) }
        registerService<JourneyDetailsService> { HciJourneyDetailsService(this, consumer) }
        registerService<JourneyPositionsService> { HciJourneyPositionsService(this, consumer) }
        registerService<TripSearchService> { HciTripSearchService(this, consumer) }
        if (true || config.ver >= "1.18") {
            registerService<StatusInformationService> {
                HciStatusInformationService(this, consumer)
            }
        }
    }
}