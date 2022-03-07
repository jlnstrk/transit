package de.jlnstrk.transit.client.hci.method.subscrcreate

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrDetails
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultStatus
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciSubscrCreateServiceResult(
  public val details: HciSubscrDetails? = null,
  public val result: HciSubscrResultStatus,
  public val subscrId: Int = 0
) : HciServiceResult()
