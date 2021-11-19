package de.jlnstrk.transit.api.hapi.response

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.HapiBooleanPair
import de.jlnstrk.transit.api.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** Result of a JorneyValidation request. */
@HapiXsd("1.29")
@Serializable
public class HapiJourneyValidation(
    public val item: List<HapiBooleanPair> = emptyList(),
) : HapiResponse()