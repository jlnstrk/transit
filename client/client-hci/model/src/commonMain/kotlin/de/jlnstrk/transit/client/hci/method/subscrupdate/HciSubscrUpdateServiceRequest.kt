package de.jlnstrk.transit.client.hci.method.subscrupdate

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrChannel
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrCon
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrIntvl
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrJourney
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrRSS
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrStatistics
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrStatus
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrUpdateServiceRequest(
  public var conSubscr: HciSubscrCon? = null,
  public var externalId: String? = null,
  public var intvlSubscr: HciSubscrIntvl? = null,
  public var jnySubscr: HciSubscrJourney? = null,
  public var language: String? = null,
  public var nPass: Int? = null,
  public var rssSubscr: HciSubscrRSS? = null,
  public var statSubscr: HciSubscrStatistics? = null,
  public var subscrId: Int? = null,
  public var userId: String? = null,
  public var channels: List<HciSubscrChannel> = emptyList(),
  public var getDetails: Boolean? = null,
  public var status: HciSubscrStatus? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciSubscrUpdateServiceRequest.() -> Unit):
        HciSubscrUpdateServiceRequest =
        de.jlnstrk.transit.client.hci.method.subscrupdate.HciSubscrUpdateServiceRequest().apply(init)
  }
}
