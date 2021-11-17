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
import de.jlnstrk.transit.api.efa.model.EfaPoint
import de.jlnstrk.transit.api.efa.request.convert.serialize
import de.jlnstrk.transit.api.efa.serializer.EfaCoordinatesStringSerializer
import de.jlnstrk.transit.api.efa.serializer.EfaPinAttributeAdapter
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

public class EfaClient private constructor(
    private val endpoint: String,
    internal var httpClient: HttpClient
) {

    public suspend fun xmlStopFinderRequest(
        request: EfaStopFinderRequest
    ): EfaStopFinderResponse = httpClient.get("${endpoint}XML_STOPFINDER_REQUEST") {
        addQueryMap(request)
    }

    public suspend fun xmlCoordRequest(
        request: EfaCoordRequest
    ): EfaCoordResponse = httpClient.get("${endpoint}XML_COORD_REQUEST") {
        addQueryMap(request)
    }

    public suspend fun xmlDmRequest(
        request: EfaDmRequest
    ): EfaDmResponse = httpClient.get("${endpoint}XML_DM_REQUEST") {
        addQueryMap(request)
    }

    public suspend fun xmlTripRequest2(
        request: EfaTripRequest
    ): EfaTripResponse = httpClient.get("${endpoint}XML_TRIP_REQUEST2") {
        addQueryMap(request)
    }

    public suspend fun xmlAddInfoRequest(
        request: EfaAddInfoRequest
    ): EfaAddInfoResponse = httpClient.get("${endpoint}XML_ADDINFO_REQUEST") {
        addQueryMap(request)
    }

    public suspend fun xmlPsRequest(
        request: EfaPsRequest
    ): EfaPsResponse = httpClient.get("${endpoint}XML_PS_REQUEST2") {
        addQueryMap(request)
    }

    public suspend fun xmlSttRequest(
        request: EfaSttRequest
    ): EfaSttResponse = httpClient.get("${endpoint}XML_STT_REQUEST") {
        addQueryMap(request)
    }

    private fun HttpRequestBuilder.addQueryMap(map: Map<String, String>) {
        for ((key, value) in map) {
            parameter(key, value)
        }
    }

    public companion object {
        public operator fun invoke(baseUrl: String, init: EfaConfig.() -> Unit = {}): EfaClient {
            val config = EfaConfig().apply(init)

            val coordinatesSerializer = EfaCoordinatesStringSerializer(config.coordinateSystem)
            val httpClient = HttpClient {
                install(JsonFeature) {
                    acceptContentTypes = acceptContentTypes + ContentType.parse("text/html")
                    serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                        classDiscriminator = ""
                        coerceInputValues = true
                        explicitNulls = false
                        ignoreUnknownKeys = true
                        serializersModule = SerializersModule {
                            contextual(coordinatesSerializer)
                            contextual(EfaPinAttributeAdapter(config.iconCodeResolver))
                            polymorphic(EfaPoint::class) {
                                default { EfaPoint.Any.serializer() }
                                subclass(EfaPoint.Any::class)
                                subclass(EfaPoint.Place::class)
                                subclass(EfaPoint.Street::class)
                                subclass(EfaPoint.SingleHouse::class)
                                subclass(EfaPoint.Poi::class)
                                subclass(EfaPoint.Stop::class)
                                subclass(EfaPoint.Crossing::class)
                                subclass(EfaPoint.PostCode::class)
                            }
                        }
                    })
                }

                val rawSystemName = config.coordinateSystem.serialize()
                defaultRequest {
                    parameter("outputFormat", "json")
                    parameter("stateless", "1")
                    parameter("coordOutputFormat", rawSystemName)
                    parameter("coordOutputFormatTail", "5")
                    parameter("mapName", rawSystemName)
                    config.language?.let { parameter("language", it) }

                    println(url.buildString())
                }
            }
            return EfaClient(baseUrl, httpClient)
        }
    }
}