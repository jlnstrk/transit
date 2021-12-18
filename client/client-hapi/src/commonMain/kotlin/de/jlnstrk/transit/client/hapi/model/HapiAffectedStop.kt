package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.location.HapiStopLocation
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiAffectedStop(
    /** List of stops affected by a message. */
    public val StopLocation: List<HapiStopLocation>,
)