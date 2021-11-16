package de.jlnstrk.transit.util.response

import de.jlnstrk.transit.util.model.*
import de.jlnstrk.transit.util.model.stop.Stop
import de.jlnstrk.transit.util.response.base.ServiceResult

public class JourneyDetailsData(
    public val direction: Location,
    public val line: Line,
    public val stops: List<Stop>? = null,
    public val polyline: Polyline? = null,
    public val messages: List<Message>? = null,
    public val attributes: List<Attribute>? = null,
    public val composition: TrainComposition? = null,
    public val isCancelled: Boolean = false,
    public val isPartiallyCancelled: Boolean = false
) : ServiceResult.Data