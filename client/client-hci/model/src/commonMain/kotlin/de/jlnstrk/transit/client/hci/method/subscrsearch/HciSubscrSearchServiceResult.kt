package de.jlnstrk.transit.client.hci.method.subscrsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultCon
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultId
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultIntvl
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultJourney
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultRSS
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultStatistics
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultStatus
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciSubscrSearchServiceResult(
  public val result: HciSubscrResultStatus,
  public val userId: String,
  public val conSubscrL: List<HciSubscrResultCon> = emptyList(),
  public val idSubscrL: List<HciSubscrResultId> = emptyList(),
  public val intvlSubscrL: List<HciSubscrResultIntvl> = emptyList(),
  public val jnySubscrL: List<HciSubscrResultJourney> = emptyList(),
  public val rssSubscrL: List<HciSubscrResultRSS> = emptyList(),
  public val statSubscrL: List<HciSubscrResultStatistics> = emptyList()
) : HciServiceResult()
