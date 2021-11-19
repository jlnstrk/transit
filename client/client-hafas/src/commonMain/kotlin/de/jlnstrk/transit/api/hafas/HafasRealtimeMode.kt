package de.jlnstrk.transit.api.hafas

import kotlinx.serialization.Serializable

@Serializable
public enum class HafasRealtimeMode {
    OFF,
    INFOS,
    FULL,
    HYBRID,
    SERVER_DEFAULT,
    REALTIME
}