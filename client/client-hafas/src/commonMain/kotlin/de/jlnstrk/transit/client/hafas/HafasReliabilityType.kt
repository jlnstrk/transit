package de.jlnstrk.transit.client.hafas

import kotlinx.serialization.Serializable

@Serializable
public enum class HafasReliabilityType {
    /** Guaranteed to get the user from A to B in time within the scope */
    GUARANTEED,

    /** Likely to get the user from A to B in time within the scope */
    HIGH,

    /** Unlikely to get the user from A to B in time within the scope */
    LOW,

    /** Definitely not going to get the user from A to B in time within the scope */
    ABORTIVE,

    /** No information */
    UNDEF,
}