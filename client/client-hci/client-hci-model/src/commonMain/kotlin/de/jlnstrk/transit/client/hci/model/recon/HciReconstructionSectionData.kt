package de.jlnstrk.transit.client.hci.model.recon

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciReconstructionSectionData(
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val aTimeR: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val aTimeS: HciLocalTime? = null,
  public val arrLoc: HciLocation,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val dTimeR: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val dTimeS: HciLocalTime? = null,
  public val depLoc: HciLocation,
  public val trainCategory: String? = null,
  public val trainName: String? = null,
  public val trainNumber: String? = null,
  public val type: HciReconstructionSectionType,
)
