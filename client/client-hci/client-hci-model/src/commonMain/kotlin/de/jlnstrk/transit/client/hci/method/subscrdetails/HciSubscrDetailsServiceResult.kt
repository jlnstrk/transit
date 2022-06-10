package de.jlnstrk.transit.client.hci.method.subscrdetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrDetails
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultStatus
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciSubscrDetailsServiceResult(
  public val details: HciSubscrDetails? = null,
  public val result: HciSubscrResultStatus,
) : HciServiceResult()
