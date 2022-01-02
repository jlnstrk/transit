package de.jlnstrk.transit.client.hci.model.geo

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciDateTimeInterval
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGeoFeatureValiditySelection(
  @Serializable(with = HciLocalDateSerializer::class)
  public val validDate: LocalDate? = null,
  public val validInterval: HciDateTimeInterval? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val validTime: HciLocalTime? = null
)
