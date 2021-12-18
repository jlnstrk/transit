@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.client.hci.method.journeygeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyDelaySummary
import de.jlnstrk.transit.client.hci.response.HciScheduleResult
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public class HciJourneyGeoPosResult(
    /** The returned journeys */
    public val jnyL: List<HciJourney> = emptyList(),

    /** The date this result was calculated on */
    public val date: LocalDate,

    /** The time this result was calculated at */
    public val time: LocalTime,

    /** The map layer associated with the returned journeys */
    public val layerX: Int?,

    /** The delay summaries for the returned journeys */
    public val summary: List<HciJourneyDelaySummary> = emptyList()
) : HciScheduleResult()