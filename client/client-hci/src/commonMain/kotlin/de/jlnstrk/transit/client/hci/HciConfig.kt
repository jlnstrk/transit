package de.jlnstrk.transit.client.hci

import de.jlnstrk.transit.util.ZoneOffset

public class HciConfig {
    public lateinit var baseUrl: String
    public lateinit var client: HciClient
    public lateinit var ver: String
    public var auth: HciAuth? = null
    public var ext: String? = null
    public var lang: String? = null

    public var timezone: ZoneOffset? = null
    public var salt: String? = null

    public companion object {
        public operator fun invoke(builder: HciConfig.() -> Unit): HciConfig =
            HciConfig().also(builder)
    }
}