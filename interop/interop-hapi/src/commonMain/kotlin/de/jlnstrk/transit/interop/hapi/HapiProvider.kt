package de.jlnstrk.transit.interop.hapi

import de.jlnstrk.transit.client.hapi.HapiClient
import de.jlnstrk.transit.common.Provider
import de.jlnstrk.transit.common.service.StationBoardService
import de.jlnstrk.transit.interop.hafas.HafasClassMapping
import de.jlnstrk.transit.interop.hapi.service.HapiStationBoardService

public abstract class HapiProvider : Provider.Implementation(), HafasClassMapping {
    public abstract val baseUrl: String
    public abstract val accessId: String

    init {
        val endpoint by lazy {
            HapiClient {
                baseUrl = this@HapiProvider.baseUrl
                accessId = this@HapiProvider.accessId
            }
        }
        registerService<StationBoardService> { HapiStationBoardService(this, endpoint) }
    }
}