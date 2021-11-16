package de.jlnstrk.transit.interop.hapi

import de.jlnstrk.transit.api.hapi.HapiEndpoint
import de.jlnstrk.transit.util.Provider
import de.jlnstrk.transit.util.service.StationBoardService
import de.jlnstrk.transit.interop.hafas.HafasClassMapping
import de.jlnstrk.transit.interop.hapi.service.HapiStationBoardService

public abstract class HapiProvider : Provider.Implementation(), HafasClassMapping {
    public abstract val baseUrl: String
    public abstract val accessId: String

    init {
        val endpoint by lazy {
            HapiEndpoint {
                baseUrl = this@HapiProvider.baseUrl
                accessId = this@HapiProvider.accessId
            }
        }
        registerService<StationBoardService> { HapiStationBoardService(this, endpoint) }
    }
}