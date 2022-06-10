package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyTrackMatchJourney(
  public val jny: HciJourney,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val matchTimeSpanBegin: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val matchTimeSpanEnd: HciLocalTime? = null,
  public val onlyGuessed: Boolean? = null,
)
