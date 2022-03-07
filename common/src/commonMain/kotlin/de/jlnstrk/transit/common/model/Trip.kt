package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.common.model.base.Identifiable
import de.jlnstrk.transit.common.model.stop.Stop

public data class Trip(
    public override val id: String,
    public val departure: Stop.Departure,
    public val arrival: Stop.Arrival,
    public val legs: List<Leg>,
    public val isRideable: Boolean = true,
    public val frequency: Frequency? = null,
    public val schedule: Schedule? = null,
    public val refreshContext: RefreshContext? = null
) : Identifiable {

    public data class Schedule(
        val text: String,
        val dates: List<LocalDate>
    )

    public interface RefreshContext
}