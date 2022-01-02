package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRing
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMatchFilterGroup(
  public val aLoc: HciLocation? = null,
  public val adjacentLocs: Boolean = false,
  public val allVias: Boolean = false,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val bDailyTime: HciLocalTime? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val bDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val bTime: HciLocalTime? = null,
  public val bidirect: Boolean = false,
  public val dLoc: HciLocation? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val eDailyTime: HciLocalTime? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val eDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val eTime: HciLocalTime? = null,
  public val iLoc: HciLocation? = null,
  public val ring: HciGeoRing? = null,
  public val sBits: String? = null,
  public val snglJnyFltr: HciHimMatchSingleJourneyFilter? = null,
  public val unique: Boolean = false,
  public val dirL: List<HciLocation> = emptyList(),
  public val jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public val viaL: List<HciLocation> = emptyList(),
  public val combineMode: HciHimMatchFilterGroupCombineMode =
      HciHimMatchFilterGroupCombineMode.UNION,
  public val realGraphMatchMode: HciHimMatchRealGraphMatchMode =
      HciHimMatchRealGraphMatchMode.PLAN_REGION
)
