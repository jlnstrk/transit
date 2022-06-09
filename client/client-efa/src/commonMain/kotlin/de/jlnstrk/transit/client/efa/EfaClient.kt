package de.jlnstrk.transit.client.efa

import de.jlnstrk.transit.client.efa.endpoint.addinfo.EfaAddInfoRequest
import de.jlnstrk.transit.client.efa.endpoint.addinfo.EfaAddInfoResponse
import de.jlnstrk.transit.client.efa.endpoint.coord.EfaCoordRequest
import de.jlnstrk.transit.client.efa.endpoint.coord.EfaCoordResponse
import de.jlnstrk.transit.client.efa.endpoint.dm.EfaDmRequest
import de.jlnstrk.transit.client.efa.endpoint.dm.EfaDmResponse
import de.jlnstrk.transit.client.efa.endpoint.ps.EfaPsRequest
import de.jlnstrk.transit.client.efa.endpoint.ps.EfaPsResponse
import de.jlnstrk.transit.client.efa.endpoint.stopfinder.EfaStopFinderRequest
import de.jlnstrk.transit.client.efa.endpoint.stopfinder.EfaStopFinderResponse
import de.jlnstrk.transit.client.efa.endpoint.stt.EfaSttRequest
import de.jlnstrk.transit.client.efa.endpoint.stt.EfaSttResponse
import de.jlnstrk.transit.client.efa.endpoint.trip.EfaTripRequest
import de.jlnstrk.transit.client.efa.endpoint.trip.EfaTripResponse
import de.jlnstrk.transit.client.efa.model.EfaPoint
import de.jlnstrk.transit.client.efa.request.convert.serialize
import de.jlnstrk.transit.client.efa.serializer.EfaCoordinatesStringSerializer
import de.jlnstrk.transit.client.efa.serializer.EfaPinAttributeSerializer
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

public class EfaClient private constructor(
    internal var httpClient: HttpClient,
    @PublishedApi internal var config: EfaConfig
) {

    public suspend fun xmlStopFinderRequest(
        request: EfaStopFinderRequest
    ): EfaStopFinderResponse = httpClient.get("XML_STOPFINDER_REQUEST") {
        addQueryMap(request)
    }.body()

    public suspend fun xmlCoordRequest(
        request: EfaCoordRequest
    ): EfaCoordResponse = httpClient.get("XML_COORD_REQUEST") {
        addQueryMap(request)
    }.body()

    public suspend fun xmlDmRequest(
        request: EfaDmRequest
    ): EfaDmResponse = httpClient.get("XML_DM_REQUEST") {
        addQueryMap(request)
    }.body()

    public suspend fun xmlTripRequest2(
        request: EfaTripRequest
    ): EfaTripResponse = httpClient.get("XML_TRIP_REQUEST2") {
        addQueryMap(request)
    }.body()

    public suspend fun xmlAddInfoRequest(
        request: EfaAddInfoRequest
    ): EfaAddInfoResponse = httpClient.get("XML_ADDINFO_REQUEST") {
        addQueryMap(request)
    }.body()

    public suspend fun xmlPsRequest(
        request: EfaPsRequest
    ): EfaPsResponse = httpClient.get("XML_PS_REQUEST2") {
        addQueryMap(request)
    }.body()

    public suspend fun xmlSttRequest(
        request: EfaSttRequest
    ): EfaSttResponse = httpClient.get("XML_STT_REQUEST") {
        addQueryMap(request)
    }.body()

    private fun HttpRequestBuilder.addQueryMap(map: Map<String, String>) {
        val rawSystemName = config.coordinateSystem.serialize()
        parameter("outputFormat", "json")
        parameter("stateless", "1")
        parameter("coordOutputFormat", rawSystemName)
        parameter("coordOutputFormatTail", "5")
        parameter("mapName", rawSystemName)

        config.language?.let { parameter("language", it) }
        for ((key, value) in map) {
            parameter(key, value)
        }
    }

    public companion object {
        public operator fun invoke(
            config: EfaConfig,
            strict: Boolean = false,
        ): EfaClient {
            val coordinatesSerializer = EfaCoordinatesStringSerializer(config.coordinateSystem)
            val httpClient = HttpClient {
                install(ContentNegotiation) {
                    val json = Json {
                        classDiscriminator = ""
                        coerceInputValues = true
                        explicitNulls = false
                        ignoreUnknownKeys = !strict
                        serializersModule = SerializersModule {
                            contextual(coordinatesSerializer)
                            contextual(EfaPinAttributeSerializer(config.iconCodeResolver))
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
                    }

                    json(json = json, contentType = ContentType.Application.Json)
                    json(json = json, contentType = ContentType.Text.Html)
                }

                install(DefaultRequest) {
                    url(config.baseUrl)
                }
                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            println(message)
                        }
                    }
                    level = LogLevel.INFO
                }
            }
            return EfaClient(httpClient, config)
        }

        public operator fun invoke(strict: Boolean = false, init: EfaConfig.() -> Unit): EfaClient =
            invoke(EfaConfig().apply(init), strict)
    }
}