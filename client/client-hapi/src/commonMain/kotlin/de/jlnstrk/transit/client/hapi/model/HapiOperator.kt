package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import kotlinx.serialization.Serializable

/** Operator info. */
@HapiXsd("1.29")
@Serializable
public data class HapiOperator(
    public val administration: List<String> = emptyList(),
    /** Operator name for display. */
    public val name: String,
    /** Operator name short. */
    public val nameS: String?,
    /** Operator name normal. */
    public val nameN: String?,
    /** Operator name long. */
    public val nameL: String?,
    /** Additional operator name. */
    public val addName: String?,
    /** Identifier */
    public val id: String?,
)