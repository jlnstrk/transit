package de.jlnstrk.transit.client.hapi.response

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.HapiMessage
import de.jlnstrk.transit.client.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** Contains notes to be displayed for this trip. */
@HapiXsd("1.29")
@Serializable
public class HapiHimMessages(
    public val Message: List<HapiMessage> = emptyList(),
) : HapiResponse()