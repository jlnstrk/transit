package de.jlnstrk.transit.api.efa

import de.jlnstrk.transit.api.efa.endpoint.addinfo.EfaAddInfoRequest
import de.jlnstrk.transit.api.efa.endpoint.addinfo.EfaAddInfoResponse
import de.jlnstrk.transit.api.efa.endpoint.coord.EfaCoordRequest
import de.jlnstrk.transit.api.efa.endpoint.coord.EfaCoordResponse
import de.jlnstrk.transit.api.efa.endpoint.dm.EfaDmRequest
import de.jlnstrk.transit.api.efa.endpoint.dm.EfaDmResponse
import de.jlnstrk.transit.api.efa.endpoint.ps.EfaPsRequest
import de.jlnstrk.transit.api.efa.endpoint.ps.EfaPsResponse
import de.jlnstrk.transit.api.efa.endpoint.stopfinder.EfaStopFinderRequest
import de.jlnstrk.transit.api.efa.endpoint.stopfinder.EfaStopFinderResponse
import de.jlnstrk.transit.api.efa.endpoint.stt.EfaSttRequest
import de.jlnstrk.transit.api.efa.endpoint.stt.EfaSttResponse
import de.jlnstrk.transit.api.efa.endpoint.trip.EfaTripRequest
import de.jlnstrk.transit.api.efa.endpoint.trip.EfaTripResponse
import io.ktor.client.*
import io.ktor.client.request.*

internal class EfaClient internal constructor(
    private val endpoint: String,
    private val httpClient: HttpClient
) : EfaEndpoint {

    override suspend fun xmlStopFinderRequest(
        request: EfaStopFinderRequest
    ): EfaStopFinderResponse = httpClient.get("${endpoint}XML_STOPFINDER_REQUEST") {
        addQueryMap(request)
    }

    override suspend fun xmlCoordRequest(
        request: EfaCoordRequest
    ): EfaCoordResponse = httpClient.get("${endpoint}XML_COORD_REQUEST") {
        addQueryMap(request)
    }

    override suspend fun xmlDmRequest(
        request: EfaDmRequest
    ): EfaDmResponse = httpClient.get("${endpoint}XML_DM_REQUEST") {
        addQueryMap(request)
    }

    override suspend fun xmlTripRequest2(
        request: EfaTripRequest
    ): EfaTripResponse = httpClient.get("${endpoint}XML_TRIP_REQUEST2") {
        addQueryMap(request)
    }

    override suspend fun xmlAddInfoRequest(
        request: EfaAddInfoRequest
    ): EfaAddInfoResponse = httpClient.get("${endpoint}XML_ADDINFO_REQUEST") {
        addQueryMap(request)
    }

    override suspend fun xmlPsRequest(
        request: EfaPsRequest
    ): EfaPsResponse = httpClient.get("${endpoint}XML_PS_REQUEST2") {
        addQueryMap(request)
    }

    override suspend fun xmlSttRequest(
        request: EfaSttRequest
    ): EfaSttResponse = httpClient.get("${endpoint}XML_STT_REQUEST") {
        addQueryMap(request)
    }

    private fun HttpRequestBuilder.addQueryMap(map: Map<String, String>) {
        for ((key, value) in map) {
            parameter(key, value)
        }
    }
}