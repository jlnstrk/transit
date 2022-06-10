package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrConSecInfo(
  public val arrivalPlatform: String? = null,
  public val arrivalStation: String? = null,
  public val arrivalStationName: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val arrivalTime: HciLocalTime? = null,
  public val changePossible: Boolean? = null,
  public val departurePlatform: String? = null,
  public val departureStation: String? = null,
  public val departureStationName: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val departureTime: HciLocalTime? = null,
  public val productCategory: String? = null,
  public val productName: String? = null,
  public val productNumber: String? = null,
  public val routeHash: String? = null,
)
