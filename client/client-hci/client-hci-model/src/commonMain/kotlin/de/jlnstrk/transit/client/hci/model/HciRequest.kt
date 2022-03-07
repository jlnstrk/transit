package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.client.HciClient
import de.jlnstrk.transit.client.hci.serializer.HciServiceRequestFrameSerializer
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciRequest(
  public val auth: HciAuth,
  public val client: HciClient,
  public val ext: HciExtension? = null,
  public val id: String? = null,
  public val lang: String,
  public val usr: HciRequestUser? = null,
  public val ver: HciVersion,
  public val svcReqL: List<@Serializable(with = HciServiceRequestFrameSerializer::class)
      HciServiceRequestFrame> = emptyList(),
  public val formatted: Boolean = false,
  public val graphIdx: Int = 0,
  public val subGraphIdx: Int = 0,
  public val viewIdx: Int = 0
)
