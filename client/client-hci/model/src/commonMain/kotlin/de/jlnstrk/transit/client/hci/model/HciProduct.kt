package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciProduct(
  public val addName: String? = null,
  public val icoX: Int? = null,
  public val name: String,
  public val nameS: String? = null,
  public val number: String? = null,
  public val oprX: Int? = null,
  public val pid: String? = null,
  public val prodCtx: HciContextProduct? = null,
  public val stat: HciProductStatus? = null,
  public val himIdL: List<String> = emptyList(),
  public val msgL: List<HciMessage> = emptyList(),
  public val cls: Int = 0
)
