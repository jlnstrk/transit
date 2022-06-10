package de.jlnstrk.transit.client.hci.method.checkintripsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.connection.HciConnection
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciCheckInTripSearchServiceResult(
  public val common: HciCommon? = null,
  public val conL: List<HciConnection> = emptyList(),
) : HciServiceResult()
