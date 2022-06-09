package de.jlnstrk.transit.client.hapi

import de.jlnstrk.transit.client.hapi.request.HapiRequest
import de.jlnstrk.transit.client.hapi.response.base.HapiResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.compression.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

public class HapiClient private constructor(
    @PublishedApi internal var httpClient: HttpClient,
    @PublishedApi internal val config: HapiConfig,
) {

    public suspend inline fun <reified Res : HapiResponse> hapiRequest(request: HapiRequest<Res>): Res {
        return httpClient.get(request.service.endpoint) {
            parameter("format", "json")
            if (url.parameters["accessId"] == null) {
                parameter("accessId", config.accessId)
            }
            config.language?.let {
                if (url.parameters["language"] == null) {
                    parameter("language", it)
                }
            }
            for ((param, value) in request) {
                parameter(param, value)
            }
        }.body()
    }

    public companion object {
        public operator fun invoke(config: HapiConfig, strict: Boolean = false): HapiClient {
            val httpClient = HttpClient {
                install(ContentNegotiation) {
                    json(json = Json {
                        coerceInputValues = true
                        explicitNulls = false
                        ignoreUnknownKeys = !strict
                    })
                }
                install(DefaultRequest) {
                    header(HttpHeaders.Accept, "application/json")
                    url(config.baseUrl)
                    println(url.buildString())
                }
                install(ContentEncoding) {
                    gzip()
                }
            }
            return HapiClient(httpClient, config)
        }

        public operator fun invoke(strict: Boolean = false, init: HapiConfig.() -> Unit): HapiClient =
            invoke(HapiConfig(init), strict)
    }
}