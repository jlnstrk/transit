package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciDurationSerializer
import kotlin.String
import kotlin.time.Duration
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciChange(
  public val durFS: HciTimeFormat? = null,
  @Serializable(with = HciDurationSerializer::class)
  public val durS: Duration? = null,
  public val txt: String,
)
