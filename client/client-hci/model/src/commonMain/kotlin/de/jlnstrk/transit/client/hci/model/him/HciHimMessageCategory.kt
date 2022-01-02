package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMessageCategory(
  public val id: Int,
  public val name: String? = null
)
