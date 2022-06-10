package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Int
import kotlin.String
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSOTContext(
  @Serializable(with = HciLocalDateSerializer::class)
  public val calcDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val calcTime: HciLocalTime? = null,
  public val cnLocX: Int? = null,
  public val ctLocX: Int? = null,
  public val ctSectX: Int? = null,
  public val jid: String? = null,
  public val masterCon: String? = null,
  public val pLocX: Int? = null,
  public val sectX: Int? = null,
  public val tName: String? = null,
  public val locMode: HciSOTMode = HciSOTMode.UNKNOWN,
  public val reqMode: HciSOTRequestMode = HciSOTRequestMode.UNKNOWN,
)
