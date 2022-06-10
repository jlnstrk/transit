package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Int
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTracePoint(
  public val crd: HciCoord,
  @Serializable(with = HciLocalDateSerializer::class)
  public val dateDB: LocalDate,
  @Serializable(with = HciLocalDateSerializer::class)
  public val dateDE: LocalDate,
  public val dev: Int = -1,
  public val ori: Int = -1,
  public val sp: Int = -1,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val timeDB: HciLocalTime,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val timeDE: HciLocalTime,
)
