package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrResultJourney(
  @Serializable(with = HciLocalDateSerializer::class)
  public val aDate: LocalDate? = null,
  public val aLoc: HciLocation? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val aTime: HciLocalTime? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val dDate: LocalDate? = null,
  public val dLoc: HciLocation? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val dTime: HciLocalTime? = null,
  public val jid: String,
  public val language: String? = null,
  public val prodName: String? = null,
  public val status: HciSubscrStatus,
  public val subscrId: Int,
  public val channels: List<HciSubscrChannel> = emptyList(),
  public val eventCount: Int = 0,
)
