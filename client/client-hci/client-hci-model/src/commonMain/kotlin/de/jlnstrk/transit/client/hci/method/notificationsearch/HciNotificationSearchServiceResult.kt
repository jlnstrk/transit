package de.jlnstrk.transit.client.hci.method.notificationsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciNotification
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.user.HciUser
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciNotificationSearchServiceResult(
  public val notificationL: List<HciNotification> = emptyList(),
  public val userL: List<HciUser> = emptyList(),
) : HciServiceResult()
