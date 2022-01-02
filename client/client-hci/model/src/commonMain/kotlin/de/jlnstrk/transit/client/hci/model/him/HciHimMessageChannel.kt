package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMessageChannel(
  @Serializable(with = HciLocalDateSerializer::class)
  public val fDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val fTime: HciLocalTime? = null,
  public val name: String? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val tDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val tTime: HciLocalTime? = null,
  public val uRefL: List<Int> = emptyList()
)
