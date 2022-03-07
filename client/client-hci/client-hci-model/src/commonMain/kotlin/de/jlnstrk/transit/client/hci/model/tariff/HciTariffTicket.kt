package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciExternalContent
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffTicket(
  public val addData: String? = null,
  public val desc: String? = null,
  public val dtl: String? = null,
  public val extCont: HciExternalContent? = null,
  public val fSecRefX: Int? = null,
  public val fStopRefX: Int? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val fValDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val fValTime: HciLocalTime? = null,
  public val icoX: Int? = null,
  public val name: String? = null,
  public val outputName: String? = null,
  public val price: HciTariffPrice? = null,
  public val tSecRefX: Int? = null,
  public val tStopRefX: Int? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val tValDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val tValTime: HciLocalTime? = null,
  public val destLocId: Int = -1,
  public val startLocId: Int = -1,
  public val typeKey: Int = -1,
  public val viaLocId: Int = -1
)
