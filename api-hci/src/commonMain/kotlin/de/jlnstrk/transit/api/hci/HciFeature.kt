package de.jlnstrk.transit.api.hci

import com.soywiz.krypto.md5
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.content.*
import io.ktor.util.*
import io.ktor.utils.io.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.async

public class HciFeature internal constructor(
    private val salt: String?
) {

    internal constructor(config: Config) : this(config.micMacSalt)

    public class Config {
        public var micMacSalt: String? = null
    }

    public companion object Feature :
        HttpClientFeature<Config, HciFeature> {
        override val key: AttributeKey<HciFeature> = AttributeKey("Hci")

        override fun prepare(block: Config.() -> Unit): HciFeature {
            val config = Config().apply(block)
            return HciFeature(config.micMacSalt)
        }

        override fun install(feature: HciFeature, scope: HttpClient) {
            scope.sendPipeline.intercept(HttpSendPipeline.State) { payload ->
                if (feature.salt != null) {
                    val body = (context.body as TextContent).bytes()
                    val mic = body.md5().hex
                    val mac = (mic.toByteArray() + feature.salt.toByteArray()).md5().hex
                    context.parameter("mic", mic)
                    context.parameter("mac", mac)
                }
                proceedWith(payload)
            }
        }
    }
}