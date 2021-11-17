package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.util.model.stop.Stop

public data class Journey(
    public val literalId: String,
    public val numericId: Long,
    public val line: Line,
    public val stop: Stop,
    public val directionFrom: Location? = null,
    public val directionTo: Location? = null,
    public val stops: List<Stop>? = null,
    public val messages: List<Message>? = null,
    public val attributes: List<Attribute>? = null,
    public val polyline: Polyline? = null,
    public val isReachable: Boolean = true,
    public val isCancelled: Boolean = false,
    public val isPartiallyCancelled: Boolean = false
)