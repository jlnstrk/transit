package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import de.jlnstrk.transit.client.hci.model.HciPolylineGroup
import de.jlnstrk.transit.client.hci.model.HciReferencedJourney
import de.jlnstrk.transit.client.hci.model.HciServiceDays
import de.jlnstrk.transit.client.hci.model.composition.HciTrainComposition
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import de.jlnstrk.transit.client.hci.model.user.HciUser
import de.jlnstrk.transit.client.hci.serializer.HciDurationSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.time.Duration
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourney(
  public val aTrnCmpSX: HciTrainComposition? = null,
  public val ani: HciJourneyPath? = null,
  public val approxDelay: Boolean = false,
  public val ctxRecon: String? = null,
  public val dTrnCmpSX: HciTrainComposition? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val date: LocalDate? = null,
  public val dirFlg: String? = null,
  public val dirLocX: Int? = null,
  public val dirTxt: String? = null,
  public val dist: Int? = null,
  @Serializable(with = HciDurationSerializer::class)
  public val durS: Duration? = null,
  public val freq: HciJourneyFreq? = null,
  public val freqRT: HciJourneyFreq? = null,
  public val hasImpRem: Boolean = false,
  public val isBase: Boolean = false,
  public val isChangeAssured: Boolean? = null,
  public val isCncl: Boolean = false,
  public val isDep: Boolean = false,
  public val isDepGeo: Boolean = false,
  public val isFallbackOnRepPos: Boolean = false,
  public val isPartActv: Boolean = false,
  public val isPartCncl: Boolean = false,
  public val isPosRep: Boolean = false,
  public val isRedir: Boolean = false,
  public val isRepLate: Boolean = false,
  public val isRepPosNotOnStopL: Boolean = false,
  public val isWait: Boolean = false,
  public val jid: String? = null,
  public val lPassSt: HciJourneyStop? = null,
  public val lPassStRT: HciJourneyStop? = null,
  public val lPosReport: String? = null,
  public val polyG: HciPolylineGroup? = null,
  public val pos: HciCoord? = null,
  public val prodX: Int? = null,
  public val prvX: Int? = null,
  public val resLDrawStyleX: Int? = null,
  public val status: HciJourneyStatus? = null,
  public val stbStop: HciJourneyStop? = null,
  public val stopCntR: Int? = null,
  public val stopCntS: Int? = null,
  public val sumLDrawStyleX: Int? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val trainStartDate: LocalDate? = null,
  public val transit: HciJourneyTransitStatus? = null,
  public val cfgGrpIdL: List<Int> = emptyList(),
  public val childJnyL: List<HciJourney> = emptyList(),
  public val dirL: List<HciJourneyDirection> = emptyList(),
  public val extUrlL: List<Int> = emptyList(),
  public val himL: List<HciJourneyHimMsg> = emptyList(),
  public val imgUrlL: List<Int> = emptyList(),
  public val msgL: List<HciMessage> = emptyList(),
  public val prodL: List<HciJourneyProduct> = emptyList(),
  public val refJnyL: List<HciReferencedJourney> = emptyList(),
  public val remL: List<HciJourneyRemark> = emptyList(),
  public val sDaysL: List<HciServiceDays> = emptyList(),
  public val stopL: List<HciJourneyStop> = emptyList(),
  public val tcocXL: List<Int> = emptyList(),
  public val userL: List<HciUser> = emptyList(),
  public val chRatingRT: Int = 0,
  public val chRatingSoll: Int = 0,
  public val chgDurR: Int = 0,
  public val dirGeo: Int = 0,
  public val isRchbl: Boolean = true,
  public val minChgDur: Int = 0,
  public val mmr: Int = 0,
  public val proc: Int = 0,
  public val procRT: Int = 0,
  public val subscr: HciJourneySubscriptionState = HciJourneySubscriptionState.U,
)
