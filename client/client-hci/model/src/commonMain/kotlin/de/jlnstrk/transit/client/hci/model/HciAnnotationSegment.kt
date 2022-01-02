package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciAnnotationSegment(
  public val polyE: Int,
  public val polyS: Int,
  public val msgL: List<HciMessage> = emptyList(),
  public val rRefL: List<Int> = emptyList()
)
