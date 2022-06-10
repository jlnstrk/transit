package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
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
public data class HciWeatherInformation(
  @Serializable(with = HciLocalDateSerializer::class)
  public val date: LocalDate,
  public val icoX: Int? = null,
  public val msgL: List<HciMessage> = emptyList(),
  public val summary: String? = null,
  public val text: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val time: HciLocalTime? = null,
  public val type: HciWeatherType,
)
