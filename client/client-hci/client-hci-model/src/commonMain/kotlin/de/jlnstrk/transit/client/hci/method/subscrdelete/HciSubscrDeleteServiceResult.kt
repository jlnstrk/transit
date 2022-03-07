package de.jlnstrk.transit.client.hci.method.subscrdelete

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultStatus
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciSubscrDeleteServiceResult(
  public val result: HciSubscrResultStatus,
  public val subscrId: Int,
  public val userId: String
) : HciServiceResult()
