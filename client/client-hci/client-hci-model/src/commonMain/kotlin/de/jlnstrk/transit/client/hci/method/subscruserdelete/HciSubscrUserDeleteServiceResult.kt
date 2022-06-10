package de.jlnstrk.transit.client.hci.method.subscruserdelete

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultStatus
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciSubscrUserDeleteServiceResult(
  public val result: HciSubscrResultStatus,
  public val userId: String,
) : HciServiceResult()
