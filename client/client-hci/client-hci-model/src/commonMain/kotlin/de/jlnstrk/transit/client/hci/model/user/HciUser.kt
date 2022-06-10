package de.jlnstrk.transit.client.hci.model.user

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciUser(
  public val aLocIdx: Int? = null,
  public val dLocIdx: Int? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val mDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val mTime: HciLocalTime? = null,
  public val uAppId: String? = null,
  public val uId: String,
  public val uMail: String? = null,
  public val uName: String? = null,
  public val uPhotoUrl: String? = null,
  public val uRole: HciUserRole = HciUserRole.U,
  public val uVisible: Boolean = false,
)
