package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciRequestConfig(
  public val cfgHash: String? = null,
  public val cfgString: String? = null,
  public val fareAuthorityID: String? = null,
  public val planrtTSMin: String? = null,
  public val statistMode: String? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val validDate: LocalDate? = null,
  public val cfgGrpL: List<HciRequestConfigGroup> = emptyList(),
  public val annoCtx: Int = 0,
  public val baimInfo: Boolean = false,
  public val obfusMode: HciObfuscationMode = HciObfuscationMode.SERVER_DEFAULT,
  public val polyEnc: HciPolylineEncoding = HciPolylineEncoding.GPA,
  public val rtMode: HciRTMode = HciRTMode.SERVER_DEFAULT,
  public val system: HciSystemType = HciSystemType.H
)
