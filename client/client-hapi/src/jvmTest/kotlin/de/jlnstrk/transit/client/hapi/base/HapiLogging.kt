package de.jlnstrk.transit.client.hapi.base

import com.soywiz.klock.DateFormat
import com.soywiz.klock.format
import de.jlnstrk.transit.util.LocalDateTime
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.*
import io.ktor.util.pipeline.*
import io.ktor.utils.io.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import java.io.File

typealias FileFactory = (String) -> File

internal class HapiLogging internal constructor(
    internal val fileFactory: FileFactory
) {

    @Serializable
    data class RequestLog(
        val url: String,
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

    companion object Feature : HttpClientFeature<Config, HapiLogging> {
        val DATE_FORMAT = DateFormat("yyyy-MM-dd-HH:mm:ss:SSS")
        val ID_KEY = AttributeKey<RequestLog>("request_id")
        val DEFAULT_FACTORY: FileFactory = { method ->
            File("$method-${DATE_FORMAT.format(LocalDateTime.now())}.json")
        }
        val WriteResponse = PipelinePhase("WriteResponse")
        override val key: AttributeKey<HapiLogging> = AttributeKey("Hci")

        override fun prepare(block: Config.() -> Unit): HapiLogging {
            val config = Config().apply(block)
            return HapiLogging(config.fileFactory ?: DEFAULT_FACTORY)
        }

        override fun install(feature: HapiLogging, scope: HttpClient) {
            scope.sendPipeline.intercept(HttpSendPipeline.State) { payload ->
                context.attributes.put(
                    ID_KEY, RequestLog(
                        url = context.url.buildString(),
                    )
                )
                proceedWith(payload)
            }

            scope.responsePipeline.insertPhaseBefore(HttpResponsePipeline.Transform, WriteResponse)
            scope.responsePipeline.intercept(WriteResponse) { (info, body) ->
                val log = context.attributes[ID_KEY]
                val body = (body as ByteReadChannel).readUTF8Line().orEmpty()
                log.responseBody = Json.parseToJsonElement(body)

                val copy = ByteReadChannel(body)
                try {
                    proceedWith(HttpResponseContainer(info, copy))
                } catch (e: Throwable) {
                    log.error = RequestLog.RequestError(
                        e.message ?: "<No message>",
                        stackTrace = e.stackTrace.map { it.toString() }
                    )
                    val service = log.url.substringAfterLast('/')
                        .substringBefore('?')
                    feature.fileFactory.invoke(service).appendText(Json {
                        prettyPrint = true
                    }.encodeToString(log))
                    throw e
                }
            }
        }
    }
}

inline fun <reified T : JsonElement> JsonElement.useAs(): T? = this as? T
