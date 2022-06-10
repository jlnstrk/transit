package de.jlnstrk.transit.client.hci.method.subscrcreate

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrChannel
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrCon
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrIntvl
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrJourney
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrRSS
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrStatistics
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrCreateServiceRequest(
  public var conSubscr: HciSubscrCon? = null,
  public var externalId: String? = null,
  public var intvlSubscr: HciSubscrIntvl? = null,
  public var jnySubscr: HciSubscrJourney? = null,
  public var language: String? = null,
  public var nPass: Int? = null,
  public var rssSubscr: HciSubscrRSS? = null,
  public var statSubscr: HciSubscrStatistics? = null,
  public var userId: String? = null,
  public var channels: List<HciSubscrChannel> = emptyList(),
  public var getDetails: Boolean? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciSubscrCreateServiceRequest.() -> Unit):
        HciSubscrCreateServiceRequest =
        de.jlnstrk.transit.client.hci.method.subscrcreate.HciSubscrCreateServiceRequest().apply(init)
  }
}
