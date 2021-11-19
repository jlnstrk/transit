package de.jlnstrk.transit.api.hapi.model

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.location.HapiStopLocation
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiAffectedStop(
    /** List of stops affected by a message. */
    public val StopLocation: List<HapiStopLocation>,
)