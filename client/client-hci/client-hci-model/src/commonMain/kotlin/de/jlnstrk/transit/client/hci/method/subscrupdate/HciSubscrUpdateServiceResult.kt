package de.jlnstrk.transit.client.hci.method.subscrupdate

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrDetails
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultStatus
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciSubscrUpdateServiceResult(
  public val details: HciSubscrDetails? = null,
  public val result: HciSubscrResultStatus,
  public val subscrId: Int = 0,
  public val userId: String,
) : HciServiceResult()
