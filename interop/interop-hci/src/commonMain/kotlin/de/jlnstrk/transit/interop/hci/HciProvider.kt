package de.jlnstrk.transit.interop.hci

import de.jlnstrk.transit.client.hci.HciConfig
import de.jlnstrk.transit.client.hci.HciConsumer
import de.jlnstrk.transit.client.hci.model.HciVersion
import de.jlnstrk.transit.common.Provider
import de.jlnstrk.transit.common.service.*
import de.jlnstrk.transit.interop.hafas.HafasClassMapping
import de.jlnstrk.transit.interop.hci.service.*
import kotlinx.datetime.TimeZone

public abstract class HciProvider : Provider.Implementation(), HafasClassMapping {
    override val timezone: TimeZone get() = TimeZone.currentSystemDefault()
    public abstract val config: HciConfig

    init {
        val consumer by lazy { HciConsumer(config) }
        registerService<LocationSearchService> { HciLocationSearchService(this, consumer) }
        registerService<NearbyLocationsService> { HciNearbyLocationsService(this, consumer) }
        registerService<StationBoardService> { HciStationBoardService(this, consumer) }
        registerService<JourneyDetailsService> { HciJourneyDetailsService(this, consumer) }
        registerService<JourneyPositionsService> { HciJourneyPositionsService(this, consumer) }
        registerService<TripSearchService> { HciTripSearchService(this, consumer) }
        if (true || config.ver >= HciVersion._1_18) {
            registerService<StatusInformationService> {
                HciStatusInformationService(this, consumer)
            }
        }
    }
}