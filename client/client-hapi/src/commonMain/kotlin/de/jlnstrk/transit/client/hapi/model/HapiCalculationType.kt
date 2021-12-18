package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import kotlinx.serialization.Serializable

/** Indicates whether the connection originated from the initial search using the original parameters,
 * or from a retried search with changed parameters that was performed after the initial search failed. */
@HapiXsd("1.29")
@Serializable
public enum class HapiCalculationType {
    /** The connection was computed during the initial request execution with the original parameters. */
    INITIAL,

    /** The connection was found using a sharp search that was performed after an unsharp search failed. */
    RETRY_SHARP,

    /** The connection was found using an unsharp search that was performed after a sharp search failed. */
    RETRY_UNSHARP,

    /** The connection was found only after the original GIS radiuses for front/back were doubled at least once. */
    RETRY_DOUBLE_RADIUS,
}