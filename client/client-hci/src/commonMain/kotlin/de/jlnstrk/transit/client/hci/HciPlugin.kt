package de.jlnstrk.transit.client.hci

import com.soywiz.krypto.md5
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.content.*
import io.ktor.util.*
import io.ktor.utils.io.core.*

public class HciPlugin internal constructor(
    private val salt: String?
) {

    internal constructor(config: Config) : this(config.micMacSalt)

    public class Config {
        public var micMacSalt: String? = null
    }

    public companion object Feature :
        HttpClientPlugin<Config, HciPlugin> {
        override val key: AttributeKey<HciPlugin> = AttributeKey("Hci")

        override fun prepare(block: Config.() -> Unit): HciPlugin {
            val config = Config().apply(block)
            return HciPlugin(config.micMacSalt)
        }

        override fun install(plugin: HciPlugin, scope: HttpClient) {
            scope.sendPipeline.intercept(HttpSendPipeline.State) { payload ->
                if (plugin.salt != null) {
                    val body = (context.body as TextContent).bytes()
                    val mic = body.md5().hex
                    val mac = (mic.toByteArray() + plugin.salt.toByteArray()).md5().hex
                    context.parameter("mic", mic)
                    context.parameter("mac", mac)
                }
                proceedWith(payload)
            }
        }
    }
}