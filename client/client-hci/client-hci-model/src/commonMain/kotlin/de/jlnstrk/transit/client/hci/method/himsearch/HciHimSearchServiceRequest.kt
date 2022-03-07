package de.jlnstrk.transit.client.hci.method.himsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciAffJnyMode
import de.jlnstrk.transit.client.hci.model.HciAffJnyStopMode
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.him.HciHimFilter
import de.jlnstrk.transit.client.hci.model.him.HciHimMessageResultElementSelector
import de.jlnstrk.transit.client.hci.model.him.HciHimMessageSortType
import de.jlnstrk.transit.client.hci.model.him.HciHimSearchMode
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimSearchServiceRequest(
  public var allowedTextTags: String? = null,
  public var bothDir: Boolean? = null,
  public var comp: String? = null,
  public var dailyB: String? = null,
  public var dailyE: String? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var dateB: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var dateE: LocalDate? = null,
  public var dept: String? = null,
  public var dirLoc: HciLocation? = null,
  public var getChildren: Boolean? = null,
  public var getParent: Boolean? = null,
  public var getPolyline: Boolean? = null,
  public var getUicList: Boolean? = null,
  public var maxPrio: Int? = null,
  public var minPrio: Int? = null,
  public var onlyToday: Boolean? = null,
  public var srvDays: String? = null,
  public var stLoc: HciLocation? = null,
  public var testMode: Int? = null,
  public var testModeData: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var timeB: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var timeE: HciLocalTime? = null,
  public var wDays: String? = null,
  public var himFltrL: List<HciHimFilter> = emptyList(),
  public var sortL: List<HciHimMessageSortType> = emptyList(),
  public var affJnyMode: HciAffJnyMode? = null,
  public var affJnyStopMode: HciAffJnyStopMode? = null,
  public var maxNum: Int? = null,
  public var mode: HciHimSearchMode? = null,
  public var resElemSelect: HciHimMessageResultElementSelector? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciHimSearchServiceRequest.() -> Unit):
        HciHimSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.himsearch.HciHimSearchServiceRequest().apply(init)
  }
}
