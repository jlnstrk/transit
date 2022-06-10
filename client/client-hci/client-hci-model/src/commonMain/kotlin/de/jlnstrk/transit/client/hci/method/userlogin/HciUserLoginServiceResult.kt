package de.jlnstrk.transit.client.hci.method.userlogin

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciUserLoginServiceResult(
  public val uId: String? = null,
) : HciServiceResult()
