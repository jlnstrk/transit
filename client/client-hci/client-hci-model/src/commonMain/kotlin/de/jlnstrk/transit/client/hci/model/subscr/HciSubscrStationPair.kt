package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.Boolean
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrStationPair(
  public val bothDir: Boolean = false,
  public val dirStop: HciLocation? = null,
  public val stop: HciLocation
)
