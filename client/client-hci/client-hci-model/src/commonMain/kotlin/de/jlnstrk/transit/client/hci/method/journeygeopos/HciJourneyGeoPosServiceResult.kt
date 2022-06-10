package de.jlnstrk.transit.client.hci.method.journeygeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyDelaySummary
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciJourneyGeoPosServiceResult(
  public val common: HciCommon? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val date: LocalDate? = null,
  public val fpB: String? = null,
  public val fpE: String? = null,
  public val planrtTS: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val time: HciLocalTime? = null,
  public val jnyL: List<HciJourney> = emptyList(),
  public val summary: List<HciJourneyDelaySummary> = emptyList(),
) : HciServiceResult()
