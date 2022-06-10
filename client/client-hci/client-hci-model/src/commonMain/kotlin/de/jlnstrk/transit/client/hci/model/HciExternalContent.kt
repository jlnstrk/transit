package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciExternalContent(
  public val content: HciContent? = null,
  public val contentAlt: List<HciContent> = emptyList(),
  public val iconX: Int? = null,
  public val provider: String? = null,
  public val providerName: String? = null,
  public val text: String? = null,
  public val textS: String? = null,
)
