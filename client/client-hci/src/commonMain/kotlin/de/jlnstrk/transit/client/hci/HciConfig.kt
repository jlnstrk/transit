package de.jlnstrk.transit.client.hci

import de.jlnstrk.transit.client.hci.model.HciAuth
import de.jlnstrk.transit.client.hci.model.HciExtension
import de.jlnstrk.transit.client.hci.model.HciVersion
import de.jlnstrk.transit.client.hci.model.client.HciClient
import de.jlnstrk.transit.util.ZoneOffset

public class HciConfig {
    public lateinit var baseUrl: String
    public lateinit var client: HciClient
    public lateinit var ver: HciVersion
    public lateinit var auth: HciAuth
    public var ext: HciExtension? = null
    public var lang: String? = null

    public var timezone: ZoneOffset? = null
    public var salt: String? = null

    public companion object {
        public operator fun invoke(builder: HciConfig.() -> Unit): HciConfig =
            HciConfig().also(builder)
    }
}