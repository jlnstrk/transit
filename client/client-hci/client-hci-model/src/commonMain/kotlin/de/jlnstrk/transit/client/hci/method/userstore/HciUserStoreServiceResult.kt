package de.jlnstrk.transit.client.hci.method.userstore

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.user.HciUser
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciUserStoreServiceResult(
  public val user: HciUser,
) : HciServiceResult()
