package de.jlnstrk.transit.api.hci

import de.jlnstrk.transit.api.hafas.HafasPolylineEncoding
import de.jlnstrk.transit.api.hafas.HafasRealtimeMode
import de.jlnstrk.transit.api.hci.request.HciRequest
import de.jlnstrk.transit.api.hci.request.HciRequestEnvelope
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import de.jlnstrk.transit.api.hci.response.HciError
import de.jlnstrk.transit.api.hci.response.HciResponse
import de.jlnstrk.transit.api.hci.response.HciServiceError
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.compression.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

public class HciConsumer private constructor(
    @PublishedApi
    internal var httpClient: HttpClient,
    @PublishedApi
    internal val url: String,
    private val baseRequest: HciRequest,
) {

    public suspend fun openRequest(request: HciRequest): HciResponse {
        return httpClient.post(url) {
            body = request
        }
    }

    public suspend inline fun <reified Req : HciServiceRequest<*>> openServiceRequest(
        request: Req
    ): HciResponse {
        return httpClient.post(url) {
            body = buildRequestBody(request)
        }
    }

    public suspend inline fun <reified Req : HciServiceRequest<Res>, reified Res : HciServiceResult> serviceRequest(
        request: Req
    ): Res? {
        return httpClient.post<HciResponse>(url) {
            body = buildRequestBody(request)
        }.let(::unwrapResult)
    }

    @PublishedApi
    internal fun buildRequestBody(serviceRequest: HciServiceRequest<*>): HciRequest {
        val frame = HciRequestEnvelope(
            serviceRequest,
            cfg = HciRequestEnvelope.Configuration(
                polyEnc = HafasPolylineEncoding.GOOGLE,
                rtMode = HafasRealtimeMode.REALTIME
            )
        )
        return baseRequest.copy(svcReqL = listOf(frame))
    }

    @PublishedApi
    internal inline fun <reified R : HciServiceResult> unwrapResult(body: HciResponse): R? {
        val error = body.err ?: body.cInfo?.code
        if (error != null && error != HciError.OK) {
            val statusMessage = body.errTxt ?: body.cInfo?.message
            if (error == HciError.CLIENTVERSION) {
                println("HCI: Wrong client version! Service requires ${body.ver}")
            }
            throw HciException.General(error, statusMessage)
        }
        if (body.svcResL.isEmpty()) {
            throw HciException.Other(message = "Response does not contain any frames!")
        }
        val frame = body.svcResL[0]
        if (frame.err != HciServiceError.OK) {
            throw HciException.Service(frame.err, frame.errTxt, frame.errTxtOut)
                .also(::println)
        }
        val result = frame.res ?: return null
        return result as? R ?: throw HciException.Other(
            message = "Wrong result for request! " +
                    "Expected ${R::class.simpleName} but got ${frame.res::class.simpleName}"
        )
    }

    public companion object {
        public operator fun invoke(config: HciConfig, strict: Boolean = false): HciConsumer {
            val httpClient = HttpClient {
                install(JsonFeature) {
                    serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                        classDiscriminator = ""
                        explicitNulls = false
                        ignoreUnknownKeys = !strict
                    })
                }
                install(HciFeature) {
                    micMacSalt = config.salt
                }
                install(ContentEncoding) {
                    gzip()
                }
                install(DefaultRequest) {
                    header(HttpHeaders.ContentType, "application/json")
                    header(HttpHeaders.Accept, "application/json")
                    header(HttpHeaders.AcceptEncoding, "gzip")
                }
            }

            val baseRequest =
                HciRequest(config.client, config.auth, config.ext, config.ver, config.lang ?: "en", emptyList())
            return HciConsumer(httpClient, config.baseUrl + "mgate.exe", baseRequest)
        }

        public operator fun invoke(strict: Boolean = false, init: HciConfig.() -> Unit): HciConsumer =
            invoke(HciConfig(init), strict)
    }
}