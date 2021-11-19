package de.jlnstrk.transit.api.hapi.response

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.HapiMessage
import de.jlnstrk.transit.api.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** Contains notes to be displayed for this trip. */
@HapiXsd("1.29")
@Serializable
public class HapiHimMessages(
    public val Message: List<HapiMessage> = emptyList(),
) : HapiResponse()