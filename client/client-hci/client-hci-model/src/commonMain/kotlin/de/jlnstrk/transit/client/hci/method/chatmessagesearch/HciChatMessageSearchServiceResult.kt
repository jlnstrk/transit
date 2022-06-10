package de.jlnstrk.transit.client.hci.method.chatmessagesearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.chat.HciChatMessage
import de.jlnstrk.transit.client.hci.model.user.HciUser
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciChatMessageSearchServiceResult(
  public val msgL: List<HciChatMessage> = emptyList(),
  public val userL: List<HciUser> = emptyList(),
) : HciServiceResult()
