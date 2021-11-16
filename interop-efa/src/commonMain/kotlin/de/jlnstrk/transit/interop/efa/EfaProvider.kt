package de.jlnstrk.transit.interop.efa

import de.jlnstrk.transit.api.efa.EfaEndpoint
import de.jlnstrk.transit.util.Provider
import de.jlnstrk.transit.util.service.*
import de.jlnstrk.transit.interop.efa.normalization.EfaNormalization
import de.jlnstrk.transit.interop.efa.service.*

public abstract class EfaProvider : Provider.Implementation(), EfaNormalization {
    public open val localeOverride: String? = null
    public abstract val baseUrl: String

    init {
        val client: EfaEndpoint by lazy {
            EfaEndpoint.newClient(baseUrl, altCodeResolver = ::resolveAltCode)
        }
        registerService<StatusInformationService> {
            EfaStatusInformationService(this, client)
        }
        registerService<StationBoardService> {
            EfaStationBoardService(this, client)
        }
        registerService<NearbyLocationsService> {
            EfaNearbyLocationsService(this, client)
        }
        registerService<LocationSearchService> {
            EfaLocationSearchService(this, client)
        }
        registerService<TripSearchService> {
            EfaTripSearchService(this, client)
        }
    }

}