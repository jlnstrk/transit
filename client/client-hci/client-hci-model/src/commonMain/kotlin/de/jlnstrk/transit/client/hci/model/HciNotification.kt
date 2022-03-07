package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.user.HciUserRole
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciNotification(
  @Serializable(with = HciLocalDateSerializer::class)
  public val date: LocalDate? = null,
  public val event: String? = null,
  public val jid: String? = null,
  public val lid: String? = null,
  public val rcvRole: HciUserRole = HciUserRole.U,
  public val rcvUId: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val time: HciLocalTime? = null,
  public val uId: String,
  public val uPos: HciCoord? = null
)