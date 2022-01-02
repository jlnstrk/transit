package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimFilter(
  public val mode: HciHimFilterMode? = null,
  public val type: HciHimFilterType,
  public val `value`: String? = null
)
