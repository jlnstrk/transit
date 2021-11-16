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
import de.jlnstrk.transit.api.efa.model.EfaCoordinateSystem
import de.jlnstrk.transit.api.efa.model.EfaMeansOfTransport
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

public interface EfaEndpoint {

    public suspend fun xmlStopFinderRequest(
        request: EfaStopFinderRequest
    ): EfaStopFinderResponse

    public suspend fun xmlCoordRequest(
        request: EfaCoordRequest
    ): EfaCoordResponse

    public suspend fun xmlDmRequest(
        request: EfaDmRequest
    ): EfaDmResponse

    public suspend fun xmlTripRequest2(
        request: EfaTripRequest
    ): EfaTripResponse

    public suspend fun xmlAddInfoRequest(
        request: EfaAddInfoRequest
    ): EfaAddInfoResponse

    public suspend fun xmlPsRequest(
        request: EfaPsRequest
    ): EfaPsResponse

    public suspend fun xmlSttRequest(
        request: EfaSttRequest
    ): EfaSttResponse

    public fun interface AltCodeResolver {
        public fun resolveAltCode(altCode: Int): EfaMeansOfTransport?
    }

    public companion object {

        public fun newClient(
            baseUrl: String,
            coordinateSystem: EfaCoordinateSystem = EfaCoordinateSystem.WGS84_DECIMAL,
            altCodeResolver: AltCodeResolver? = null,
            language: String? = null
        ): EfaEndpoint {
            val coordinatesSerializer = EfaCoordinatesStringSerializer(coordinateSystem)
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
                            contextual(EfaPinAttributeAdapter(altCodeResolver))
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

                val rawSystemName = coordinateSystem.serialize()
                defaultRequest {
                    parameter("outputFormat", "json")
                    parameter("stateless", "1")
                    parameter("coordOutputFormat", rawSystemName)
                    parameter("coordOutputFormatTail", "5")
                    parameter("mapName", coordinateSystem.serialize())
                    language?.let {
                        parameter("language", it)
                    }

                    println(url.buildString())
                }
            }
            return EfaClient(baseUrl, httpClient)
        }
    }
}