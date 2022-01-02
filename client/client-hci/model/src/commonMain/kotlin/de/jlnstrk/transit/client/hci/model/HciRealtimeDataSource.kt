package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciRealtimeDataSource(
  public val freeTextIdCount: Int? = null,
  public val heartbeatTS: String? = null,
  public val name: String? = null,
  public val type: HciRealtimeDataSourceType = HciRealtimeDataSourceType.DEFAULT
)
