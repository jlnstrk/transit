package de.jlnstrk.transit.client.hci.base

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
        private val DATE_FORMAT = DateFormat("yyyy-MM-dd-HH:mm:ss:SSS")
        private val ID_KEY = AttributeKey<RequestLog>("request_id")
        val DEFAULT_FACTORY: FileFactory = { method ->
            File("$method-${DATE_FORMAT.format(LocalDateTime.now())}.json")
        }
        private val WriteResponse = PipelinePhase("WriteResponse")
        override val key: AttributeKey<HciLogging> = AttributeKey("Hci")

        override fun prepare(block: Config.() -> Unit): HciLogging {
            val config = Config().apply(block)
            return HciLogging(config.fileFactory ?: DEFAULT_FACTORY)
        }

        private val json = Json {
            prettyPrint = true
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
                val bodyText = (body as ByteReadChannel).readUTF8Line().orEmpty()
                log.responseBody = Json.parseToJsonElement(bodyText)

                val method = log.requestBody
                    .safeCast<JsonObject>()
                    ?.get("svcReqL")
                    ?.safeCast<JsonArray>()
                    ?.get(0)
                    ?.safeCast<JsonObject>()
                    ?.get("meth")
                    ?.jsonPrimitive
                    ?.content ?: "<Unknown method>"

                val copy = ByteReadChannel(bodyText)
                try {
                    proceedWith(HttpResponseContainer(info, copy))
                    feature.fileFactory.invoke(method).appendText(json.encodeToString(log))
                } catch (e: Throwable) {
                    log.error = RequestLog.RequestError(
                        e.message ?: "<No message>",
                        stackTrace = e.stackTrace.map { it.toString() }
                    )
                    feature.fileFactory.invoke(method).appendText(json.encodeToString(log))
                    throw e
                }
            }
        }
    }
}

inline fun <reified T : JsonElement> JsonElement.safeCast(): T? = this as? T
