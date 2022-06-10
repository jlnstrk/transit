package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.recon.HciReconstructionSectionData
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyTrackSectionData(
  @Serializable(with = HciLocalDateSerializer::class)
  public val date: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val matchTimeSpanBegin: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val matchTimeSpanEnd: HciLocalTime? = null,
  public val secData: HciReconstructionSectionData? = null,
)
