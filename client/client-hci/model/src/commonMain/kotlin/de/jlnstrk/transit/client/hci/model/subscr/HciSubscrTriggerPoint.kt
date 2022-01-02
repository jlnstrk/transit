package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrTriggerPoint(
  public val loc: HciLocation,
  public val proc: Int,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val time: HciLocalTime
)
