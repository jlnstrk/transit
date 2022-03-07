package de.jlnstrk.transit.client.hci.method.subscruserupdate

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultStatus
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrUserDetails
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciSubscrUserUpdateServiceResult(
  public val details: HciSubscrUserDetails? = null,
  public val result: HciSubscrResultStatus,
  public val userId: String
) : HciServiceResult()
