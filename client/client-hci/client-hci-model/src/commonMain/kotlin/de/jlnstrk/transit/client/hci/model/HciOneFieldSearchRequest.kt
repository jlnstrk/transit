package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciOneFieldSearchRequest(
  public val type: HciOneFieldSearchRequestType,
  public val arrLocRefL: List<Int> = emptyList(),
  public val depLocRefL: List<Int> = emptyList(),
  public val viaLocRefL: List<Int> = emptyList(),
)
