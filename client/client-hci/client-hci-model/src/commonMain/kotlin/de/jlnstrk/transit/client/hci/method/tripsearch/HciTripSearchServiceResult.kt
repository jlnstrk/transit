package de.jlnstrk.transit.client.hci.method.tripsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciSOTContext
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.HciTripSearchResultStatus
import de.jlnstrk.transit.client.hci.model.connection.HciConnection
import de.jlnstrk.transit.client.hci.model.connection.HciConnectionScoreGroupSettings
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffResult
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciTripSearchServiceResult(
  public val common: HciCommon? = null,
  public val fpB: String? = null,
  public val fpE: String? = null,
  public val outConGrpSettings: HciConnectionScoreGroupSettings? = null,
  public val outCtxScrB: String? = null,
  public val outCtxScrF: String? = null,
  public val planrtTS: String? = null,
  public val resultStatus: HciTripSearchResultStatus? = null,
  public val retConGrpSettings: HciConnectionScoreGroupSettings? = null,
  public val retCtxScrB: String? = null,
  public val retCtxScrF: String? = null,
  public val sotCtxt: HciSOTContext? = null,
  public val trfRes: HciTariffResult? = null,
  public val outConL: List<HciConnection> = emptyList(),
  public val outGlobMsgL: List<HciMessage> = emptyList(),
  public val retConL: List<HciConnection> = emptyList(),
  public val retGlobMsgL: List<HciMessage> = emptyList(),
  public val bfATS: Int = 0,
  public val bfIOSTS: Int = 0
) : HciServiceResult()
