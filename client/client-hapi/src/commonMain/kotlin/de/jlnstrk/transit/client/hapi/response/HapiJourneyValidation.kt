package de.jlnstrk.transit.client.hapi.response

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.HapiBooleanPair
import de.jlnstrk.transit.client.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** Result of a JorneyValidation request. */
@HapiXsd("1.29")
@Serializable
public class HapiJourneyValidation(
    public val item: List<HapiBooleanPair> = emptyList(),
) : HapiResponse()