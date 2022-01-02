package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciRequestParameterGroup(
  public val elmX: Int? = null,
  public val meth: HciServiceMethod,
  public val type: HciRequestParameterGroupType
)
