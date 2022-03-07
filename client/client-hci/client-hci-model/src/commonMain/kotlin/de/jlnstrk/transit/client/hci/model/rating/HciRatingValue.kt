package de.jlnstrk.transit.client.hci.model.rating

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciRatingValue(
  public val cnt: Int = -1,
  public val key: HciRatingKey,
  public val `val`: Int
)
