package de.jlnstrk.transit.client.hci.method.journeycourse

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciPolylineGroup
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRect
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciJourneyCourseServiceResult(
  public val common: HciCommon? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val date: LocalDate? = null,
  public val edgePolys: List<HciPolylineGroup> = emptyList(),
  public val jnyL: List<HciJourney> = emptyList(),
  public val mainPoly: HciPolylineGroup? = null,
  public val rect: HciGeoRect? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val time: HciLocalTime? = null
) : HciServiceResult()
