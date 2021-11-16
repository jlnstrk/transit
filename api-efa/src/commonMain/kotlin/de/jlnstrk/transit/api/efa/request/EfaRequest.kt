package de.jlnstrk.transit.api.efa.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@DslMarker
internal annotation class EfaRequestDsl

/**
 * Base class for requests to EFA endpoints.
 * Implements string [Map] to be decomposable into query param key/value pairs
 */
@EfaRequestDsl
public abstract class EfaRequest internal constructor(
    override val queryMap: EfaRequestMap = EfaRequestMap()
) : Map<String, String> by queryMap, EfaRequestMapDelegate {

    @Serializable
    public enum class DateTimeMode {
        @SerialName("dep")
        DEPARTURE,

        @SerialName("arr")
        ARRIVAL,

        @SerialName("firstService")
        FIRST_SERVICE,

        @SerialName("lastService")
        LAST_SERVICE
    }

    @Serializable
    public enum class AmPmMode {
        @SerialName("am")
        AM,

        @SerialName("pm")
        PM,
    }
}