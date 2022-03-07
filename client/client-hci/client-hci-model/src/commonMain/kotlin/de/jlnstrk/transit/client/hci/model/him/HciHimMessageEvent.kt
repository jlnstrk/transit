package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMessageEvent(
  @Serializable(with = HciLocalDateSerializer::class)
  public val fDate: LocalDate? = null,
  public val fLocX: Int? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val fTime: HciLocalTime? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val tDate: LocalDate? = null,
  public val tLocX: Int? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val tTime: HciLocalTime? = null,
  public val sectionNums: List<String> = emptyList(),
  public val isCurrent: Boolean = false
)
