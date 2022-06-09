package de.jlnstrk.transit.client.hci

import de.jlnstrk.transit.client.hci.model.*
import de.jlnstrk.transit.client.hci.util.method
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.compression.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

public class HciConsumer private constructor(
    @PublishedApi
    internal var httpClient: HttpClient,
    @PublishedApi
    internal val url: String,
    private val baseRequest: HciRequest,
) {

    public suspend fun openRequest(request: HciRequest): HciResult {
        return httpClient.post(url) {
            setBody(request)
        }.body()
    }

    public suspend inline fun <reified Req : HciServiceRequest> openServiceRequest(
        request: Req
    ): HciResult {
        return httpClient.post(url) {
            setBody(buildRequestBody(request))
        }.body()
    }

    public suspend inline fun <reified Res : HciServiceResult> serviceRequest(
        request: HciServiceRequest
    ): Res? {
        return httpClient.post(url) {
            setBody(buildRequestBody(request))
        }.body<HciResult>().let(::unwrapResult)
    }

    @PublishedApi
    internal fun buildRequestBody(serviceRequest: HciServiceRequest): HciRequest {
        val frame = HciServiceRequestFrame(
            cfg = HciRequestConfig(
                polyEnc = HciPolylineEncoding.GPA,
                rtMode = HciRTMode.REALTIME,
                obfusMode = HciObfuscationMode.SERVER_DEFAULT,
                system = HciSystemType.H,
            ),
            meth = serviceRequest.method,
            req = serviceRequest
        )
        return baseRequest.copy(svcReqL = listOf(frame))
    }

    @PublishedApi
    internal inline fun <reified R : HciServiceResult> unwrapResult(body: HciResult): R? {
        val error = body.err
        if (error != HciCoreError.OK) {
            val statusMessage = body.errTxt ?: body.cInfo?.msg
            if (error == HciCoreError.CLIENTVERSION) {
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
                    "Expected ${R::class.simpleName} but got ${result::class.simpleName}"
        )
    }

    public companion object {
        public operator fun invoke(config: HciConfig, strict: Boolean = false): HciConsumer {
            val httpClient = HttpClient {
                install(ContentNegotiation) {
                    json(json = Json {
                        classDiscriminator = ""
                        explicitNulls = false
                        ignoreUnknownKeys = !strict
                        coerceInputValues = true
                    })
                }
                install(HciPlugin) {
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

            val baseRequest = HciRequest(
                auth = config.auth,
                client = config.client,
                ext = config.ext,
                id = null,
                lang = config.lang ?: "en",
                usr = null,
                ver = config.ver,
                svcReqL = emptyList(),
                formatted = false,
                graphIdx = 0,
                subGraphIdx = 0,
                viewIdx = 0,
            )
            return HciConsumer(httpClient, config.baseUrl + "mgate.exe", baseRequest)
        }

        public operator fun invoke(strict: Boolean = false, init: HciConfig.() -> Unit): HciConsumer =
            invoke(HciConfig(init), strict)
    }
}