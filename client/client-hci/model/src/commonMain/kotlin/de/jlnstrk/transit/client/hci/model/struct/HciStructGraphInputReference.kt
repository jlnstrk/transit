package de.jlnstrk.transit.client.hci.model.struct

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciStructGraphInputReference(
  public val arrLoc: HciLocation? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val date: LocalDate? = null,
  public val depLoc: HciLocation? = null,
  public val jid: String? = null,
  public val method: HciStructGraphMethod = HciStructGraphMethod.JOURNEY_COURSE,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val time: HciLocalTime? = null
)
