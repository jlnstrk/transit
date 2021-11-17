package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.common.model.stop.Stop

public data class Journey(
    public val id: String,
    public val line: Line,
    public val stop: Stop,
    public val directionFrom: Location? = null,
    public val directionTo: Location? = null,
    public val stops: List<Stop> = emptyList(),
    public val messages: List<Message> = emptyList(),
    public val attributes: List<Attribute> = emptyList(),

    public val position: Coordinates? = null,
    public val polyline: Polyline? = null,

    public val isReachable: Boolean = true,
    public val isCancelled: Boolean = false,
    public val isPartiallyCancelled: Boolean = false
)