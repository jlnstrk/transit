package de.jlnstrk.transit.api.efa.endpoint.dm

import de.jlnstrk.transit.api.efa.model.EfaMode
import kotlinx.serialization.Serializable

@Serializable
public class EfaLineEntry(
    public val mode: EfaMode,
    public val index: String,
    public val assignedStop: String? = null,
    public val assignedStopID: String? = null
)