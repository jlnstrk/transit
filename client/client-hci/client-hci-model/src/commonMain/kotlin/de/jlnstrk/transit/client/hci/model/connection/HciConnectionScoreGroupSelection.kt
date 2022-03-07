package de.jlnstrk.transit.client.hci.model.connection

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciConnectionScoreGroupSelection(
  public val bitIdx: Int? = null,
  public val icoX: Int? = null,
  public val name: String? = null
)
