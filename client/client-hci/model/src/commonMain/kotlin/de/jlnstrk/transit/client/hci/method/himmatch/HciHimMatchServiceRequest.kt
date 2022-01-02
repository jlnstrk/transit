package de.jlnstrk.transit.client.hci.method.himmatch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchEntryExitMode
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchFilterGroup
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchImpactType
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchLineListMode
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchMatchEquivalentRegionMode
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchMatchSegmentsType
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchTrainMatchMode
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMatchServiceRequest(
  public var advanced: Boolean? = null,
  public var lineList: Boolean? = null,
  public var msgSourceFilter: String? = null,
  public var passlist: Boolean? = null,
  public var retAffOp: Boolean? = null,
  public var retAffReg: Boolean? = null,
  public var retAffRoutes: Boolean? = null,
  public var retAffSt: Boolean? = null,
  public var retHimJrnResNum: Boolean? = null,
  public var retHimMsgContent: Boolean? = null,
  public var retJourneys: Boolean? = null,
  public var retOnlyMainMast: Boolean? = null,
  public var retResNum: Boolean? = null,
  public var retWarnAll: Boolean? = null,
  public var serviceBits: Boolean? = null,
  public var testMode: Int? = null,
  public var testModeData: String? = null,
  public var trainFromMatch: Boolean? = null,
  public var trainNameList: Boolean? = null,
  public var withKw: Boolean? = null,
  public var fltrGrpL: List<HciHimMatchFilterGroup> = emptyList(),
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var entryExitMode: HciHimMatchEntryExitMode? = null,
  public var impact: HciHimMatchImpactType? = null,
  public var lineListMode: HciHimMatchLineListMode? = null,
  public var matchEquivRegionMode: HciHimMatchMatchEquivalentRegionMode? = null,
  public var matchSegments: HciHimMatchMatchSegmentsType? = null,
  public var maxRes: Int? = null,
  public var trainMatchMode: HciHimMatchTrainMatchMode? = null,
  public var trainNameMatchFormat: Int? = null,
  public var trainNumberMatchType: Int? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciHimMatchServiceRequest.() -> Unit):
        HciHimMatchServiceRequest =
        de.jlnstrk.transit.client.hci.method.himmatch.HciHimMatchServiceRequest().apply(init)
  }
}
