package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Int
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciPartialSearchSegment(
  @Serializable(with = HciLocalDateSerializer::class)
  public val beginDate: LocalDate? = null,
  public val beginLoc: HciLocation,
  public val beginSupplChgTime: Int? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val beginTime: HciLocalTime? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val endDate: LocalDate? = null,
  public val endLoc: HciLocation,
  public val endSupplChgTime: Int? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val endTime: HciLocalTime? = null,
)
