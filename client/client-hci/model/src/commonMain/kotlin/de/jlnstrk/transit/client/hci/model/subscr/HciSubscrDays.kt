package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrDays(
  @Serializable(with = HciLocalDateSerializer::class)
  public val beginDate: LocalDate,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val beginTime: HciLocalTime? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val endDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val endTime: HciLocalTime? = null,
  public val monitoredDays: String? = null,
  public val noMsgFrom: String? = null,
  public val noMsgTo: String? = null,
  public val pauseBegin: String? = null,
  public val pauseEnd: String? = null,
  public val selectedDays: String? = null,
  public val selectedWeekdays: String? = null
)
