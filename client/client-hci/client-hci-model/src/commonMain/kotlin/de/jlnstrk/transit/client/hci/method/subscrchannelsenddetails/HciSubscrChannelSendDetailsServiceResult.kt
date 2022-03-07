package de.jlnstrk.transit.client.hci.method.subscrchannelsenddetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultStatus
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciSubscrChannelSendDetailsServiceResult(
  public val result: HciSubscrResultStatus
) : HciServiceResult()
