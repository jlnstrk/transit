package de.jlnstrk.transit.api.hapi.model

import de.jlnstrk.transit.api.hafas.HapiXsd
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiResourceLink(
    public val rel: String,
    public val href: String,
)