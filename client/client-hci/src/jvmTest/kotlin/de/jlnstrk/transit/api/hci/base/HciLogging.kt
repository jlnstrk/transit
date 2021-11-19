package de.jlnstrk.transit.api.hci.base

import com.soywiz.klock.DateFormat
import com.soywiz.klock.format
import de.jlnstrk.transit.util.LocalDateTime
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.content.*
import io.ktor.util.*
import io.ktor.util.pipeline.*
import io.ktor.utils.io.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import java.io.File

typealias FileFactory = (String) -> File

internal class HciLogging internal constructor(
    internal val fileFactory: FileFactory
) {

    @Serializable
    data class RequestLog(
        val url: String,
        val requestBody: JsonElement,
        var responseBody: JsonElement? = null,
        var error: RequestError? = null
    ) {
        @Serializable
        data class RequestError(
            val message: String,
            val stackTrace: List<String>
        )
    }

    internal constructor(config: Config) : this(config.fileFactory ?: DEFAULT_FACTORY)

    internal class Config {
        internal var fileFactory: FileFactory? = null
    }

    companion object Feature : HttpClientFeature<Config, HciLogging> {
        val DATE_FORMAT = DateFormat("yyyy-MM-dd-HH:mm:ss:SSS")
        val ID_KEY = AttributeKey<RequestLog>("request_id")
        val DEFAULT_FACTORY: FileFactory = { method ->
            File("$method-${DATE_FORMAT.format(LocalDateTime.now())}.json")
        }
        val WriteResponse = PipelinePhase("WriteResponse")
        override val key: AttributeKey<HciLogging> = AttributeKey("Hci")

        override fun prepare(block: Config.() -> Unit): HciLogging {
            val config = Config().apply(block)
            return HciLogging(config.fileFactory ?: DEFAULT_FACTORY)
        }

        override fun install(feature: HciLogging, scope: HttpClient) {
            scope.sendPipeline.intercept(HttpSendPipeline.State) { payload ->
                context.attributes.put(
                    ID_KEY, RequestLog(
                        url = context.url.buildString(),
                        requestBody = Json.parseToJsonElement((context.body as TextContent).text)
                    )
                )
                proceedWith(payload)
            }

            scope.responsePipeline.insertPhaseBefore(HttpResponsePipeline.Transform, WriteResponse)
            scope.responsePipeline.intercept(WriteResponse) { (info, body) ->
                val log = context.attributes[ID_KEY]
                val body = (body as ByteReadChannel).readUTF8Line().orEmpty()
                log.responseBody = Json.parseToJsonElement(body)

                val method = log.requestBody
                    ?.useAs<JsonObject>()
                    ?.get("svcReqL")
                    ?.useAs<JsonArray>()
                    ?.get(0)
                    ?.useAs<JsonObject>()
                    ?.get("meth")
                    ?.jsonPrimitive
                    ?.content ?: "<Unknown method>"

                val copy = ByteReadChannel(body)
                try {
                    proceedWith(HttpResponseContainer(info, copy))
                } catch (e: Throwable) {
                    log.error = RequestLog.RequestError(
                        e.message ?: "<No message>",
                        stackTrace = e.stackTrace.map { it.toString() }
                    )
                    feature.fileFactory.invoke(method).appendText(Json {
                        prettyPrint = true
                    }.encodeToString(log))
                    throw e
                }
            }
        }
    }
}

inline fun <reified T : JsonElement> JsonElement.useAs(): T? = this as? T
