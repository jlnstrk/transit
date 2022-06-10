package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.client.HciClientInfo
import de.jlnstrk.transit.client.hci.serializer.HciServiceResultFrameSerializer
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciResult(
  public val cInfo: HciClientInfo? = null,
  public val errTxt: String? = null,
  public val ext: HciExtension? = null,
  public val `get`: String? = null,
  public val graph: HciGraph? = null,
  public val hammError: String? = null,
  public val id: String? = null,
  public val lang: String? = null,
  public val subGraph: HciSubGraph? = null,
  public val ver: HciVersion,
  public val view: HciView? = null,
  public val svcResL: List<@Serializable(with = HciServiceResultFrameSerializer::class)
      HciServiceResultFrame> = emptyList(),
  public val err: HciCoreError = HciCoreError.OK,
)
