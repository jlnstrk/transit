package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimImpact(
  public val addImpact: String? = null,
  public val icoX: Int,
  public val impact: String? = null,
  public val prio: Int,
  public val prodCode: String? = null,
  public val products: Int
)
