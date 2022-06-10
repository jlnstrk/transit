package de.jlnstrk.transit.client.hci.model.rating

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciRating(
  @Serializable(with = HciLocalDateSerializer::class)
  public val date: LocalDate? = null,
  public val jid: String? = null,
  public val jny: HciJourney? = null,
  public val lid: String? = null,
  public val loc: HciLocation? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val time: HciLocalTime? = null,
  public val uId: String? = null,
  public val uPos: HciCoord? = null,
  public val valueL: List<HciRatingValue> = emptyList(),
)
