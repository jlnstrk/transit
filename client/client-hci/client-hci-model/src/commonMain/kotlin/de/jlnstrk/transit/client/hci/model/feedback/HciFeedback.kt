package de.jlnstrk.transit.client.hci.model.feedback

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import de.jlnstrk.transit.client.hci.model.user.HciUserRole
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.String
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciFeedback(
  @Serializable(with = HciLocalDateSerializer::class)
  public val date: LocalDate? = null,
  public val jid: String? = null,
  public val lid: String? = null,
  public val photoUrl: String? = null,
  public val place: String? = null,
  public val rcvRole: HciUserRole = HciUserRole.U,
  public val rcvUId: String? = null,
  public val text: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val time: HciLocalTime? = null,
  public val uId: String,
  public val uPos: HciCoord? = null,
)
