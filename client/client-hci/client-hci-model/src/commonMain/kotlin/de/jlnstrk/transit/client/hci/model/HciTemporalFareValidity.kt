package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTemporalFareValidity(
  public val BD: String? = null,
  public val BT: String? = null,
  public val ED: String? = null,
  public val ET: String? = null,
  public val RD: String? = null,
  public val VC: String? = null,
  public val TD: List<String> = emptyList(),
  public val VD: Int = -1
)
