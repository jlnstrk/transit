package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocationType
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import kotlin.Int
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciPoolInfo(
  @Serializable(with = HciLocalDateSerializer::class)
  public val beginDate: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val endDate: LocalDate? = null,
  public val index: Int,
  public val subType: HciLocationType = HciLocationType.U,
  public val timeStamp: Int = -1,
  public val uic: Int,
)
