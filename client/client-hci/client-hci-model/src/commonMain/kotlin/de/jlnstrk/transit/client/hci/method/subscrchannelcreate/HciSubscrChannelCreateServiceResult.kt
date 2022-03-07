package de.jlnstrk.transit.client.hci.method.subscrchannelcreate

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrChannel
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultStatus
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciSubscrChannelCreateServiceResult(
  public val channel: HciSubscrChannel? = null,
  public val result: HciSubscrResultStatus
) : HciServiceResult()
