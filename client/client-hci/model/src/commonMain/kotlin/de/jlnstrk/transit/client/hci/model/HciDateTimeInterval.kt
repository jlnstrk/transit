package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciDateTimeInterval(
  @Serializable(with = HciLocalDateSerializer::class)
  public val endDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val endTime: HciLocalTime? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val startDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val startTime: HciLocalTime? = null
)
