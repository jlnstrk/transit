package de.jlnstrk.transit.api.hapi

import de.jlnstrk.transit.api.hapi.request.HapiRequest
import de.jlnstrk.transit.api.hapi.response.base.HapiResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.compression.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

public class HapiClient private constructor(
    @PublishedApi internal var httpClient: HttpClient,
    @PublishedApi internal val baseUrl: String,
) {

    public suspend inline fun <reified Res : HapiResponse> hapiRequest(request: HapiRequest<Res>): Res {
        return httpClient.get(baseUrl + request.service.endpoint) {
            for ((param, value) in request) {
                parameter(param, value)
            }
        }
    }

    public companion object {
        public operator fun invoke(config: HapiConfig): HapiClient {
            val httpClient = HttpClient {
                install(JsonFeature) {
                    serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                        coerceInputValues = true
                        explicitNulls = false
                    })
                }
                install(DefaultRequest) {
                    header(HttpHeaders.Accept, "application/json")
                    parameter("format", "json")
                    if (url.parameters["accessId"] == null) {
                        parameter("accessId", config.accessId)
                    }
                    config.language?.let {
                        if (url.parameters["language"] == null) {
                            parameter("language", it)
                        }
                    }

                    println(url.buildString())
                }
                install(ContentEncoding) {
                    gzip()
                }
            }
            return HapiClient(httpClient, config.baseUrl)
        }

        public operator fun invoke(init: HapiConfig.() -> Unit): HapiClient = HapiConfig(init).let(::invoke)
    }
}