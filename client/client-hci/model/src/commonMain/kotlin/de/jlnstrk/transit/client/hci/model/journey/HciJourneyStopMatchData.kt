package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyStopMatchData(
  public val guessedStop: Boolean? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val matchArrTime: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val matchDepTime: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val maxArrTime: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val maxDepTime: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val minArrTime: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val minDepTime: HciLocalTime? = null
)
