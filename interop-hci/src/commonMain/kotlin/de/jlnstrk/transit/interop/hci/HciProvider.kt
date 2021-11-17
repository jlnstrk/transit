package de.jlnstrk.transit.interop.hci

import de.jlnstrk.transit.api.hci.HciConsumer
import de.jlnstrk.transit.api.hci.HciAuth
import de.jlnstrk.transit.api.hci.HciClient
import de.jlnstrk.transit.util.LocalDateTime
import de.jlnstrk.transit.interop.Provider
import de.jlnstrk.transit.util.ZoneOffset
import de.jlnstrk.transit.util.service.*
import de.jlnstrk.transit.interop.hafas.HafasClassMapping
import de.jlnstrk.transit.interop.hci.service.*

public abstract class HciProvider : de.jlnstrk.transit.interop.Provider.Implementation(), HafasClassMapping {
    override val timezone: ZoneOffset get() = ZoneOffset.local(LocalDateTime.now())

    public abstract val baseUrl: String

    public abstract val client: HciClient
    public open val auth: HciAuth? get() = null
    public abstract val ver: String
    public open val ext: String? get() = null
    public open val salt: String? get() = null
    public open val localeOverride: String? get() = null

    init {
        val endpoint by lazy {
            HciConsumer {
                baseUrl = this@HciProvider.baseUrl
                client = this@HciProvider.client
                ver = this@HciProvider.ver
                ext = this@HciProvider.ext
                auth = this@HciProvider.auth
                lang = this@HciProvider.localeOverride
                salt = this@HciProvider.salt
            }
        }
        registerService<LocationSearchService> { HciLocationSearchService(this, endpoint) }
        registerService<NearbyLocationsService> { HciNearbyLocationsService(this, endpoint) }
        registerService<StationBoardService> { HciStationBoardService(this, endpoint) }
        registerService<JourneyDetailsService> { HciJourneyDetailsService(this, endpoint) }
        registerService<TripSearchService> { HciTripSearchService(this, endpoint) }
        if (true || ver >= "1.18") {
            registerService<StatusInformationService> {
                HciStatusInformationService(this, endpoint)
            }
        }
    }

}