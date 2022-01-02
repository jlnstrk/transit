package de.jlnstrk.transit.client.hci.method.usersearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.user.HciUser
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciUserSearchServiceResult(
  public val userL: List<HciUser> = emptyList()
) : HciServiceResult()
