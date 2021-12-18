package de.jlnstrk.transit.client.hapi

public class HapiConfig {
    public lateinit var baseUrl: String
    public lateinit var accessId: String
    public var enabledServices: Set<HapiEndpoint> = emptySet()
    public var language: String? = null

    public companion object {
        public inline operator fun invoke(init: HapiConfig.() -> Unit): HapiConfig =
            HapiConfig().apply(init)
    }
}