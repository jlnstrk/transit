package de.jlnstrk.transit.client.hci.model.connection

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciConSection
import de.jlnstrk.transit.client.hci.model.HciConSubscriptionState
import de.jlnstrk.transit.client.hci.model.HciDBReiseplanStorageData
import de.jlnstrk.transit.client.hci.model.HciIntvlSubscriptionState
import de.jlnstrk.transit.client.hci.model.HciReservationRecommendation
import de.jlnstrk.transit.client.hci.model.HciReservationState
import de.jlnstrk.transit.client.hci.model.HciSOTContext
import de.jlnstrk.transit.client.hci.model.HciServiceDays
import de.jlnstrk.transit.client.hci.model.composition.HciTrainComposition
import de.jlnstrk.transit.client.hci.model.eco.HciEco
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFreq
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyStop
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import de.jlnstrk.transit.client.hci.model.recon.HciReconstruction
import de.jlnstrk.transit.client.hci.model.recon.HciReconstructionState
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffRef
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffResult
import de.jlnstrk.transit.client.hci.model.user.HciUser
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciConnection(
  public val aTrnCmpSX: HciTrainComposition? = null,
  public val arr: HciJourneyStop? = null,
  public val badSecRefX: Int? = null,
  public val chg: Int? = null,
  public val cid: String? = null,
  public val cksum: String? = null,
  public val cksumDti: String? = null,
  public val combinedMinDuration: String? = null,
  public val conStatus: HciConnectionStatus? = null,
  public val dTrnCmpSX: HciTrainComposition? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val date: LocalDate? = null,
  public val dbReiseplanStorageData: HciDBReiseplanStorageData? = null,
  public val dep: HciJourneyStop? = null,
  public val dur: String? = null,
  public val durR: String? = null,
  public val durS: String? = null,
  public val eco: HciEco? = null,
  public val ecoEntryUrl: String? = null,
  public val freq: HciJourneyFreq? = null,
  public val freqRT: HciJourneyFreq? = null,
  public val hasAlt: Boolean = false,
  public val hasImpRem: Boolean = false,
  public val hasIndividualChangeTimes: Boolean = false,
  public val isAlt: Boolean = false,
  public val isNotRdbl: Boolean = false,
  public val isPref: Boolean = false,
  public val isSotCon: Boolean = false,
  public val recon: HciReconstruction? = null,
  public val reliability: HciConnectionReliability? = null,
  public val sDays: HciServiceDays? = null,
  public val showARSLink: Boolean = false,
  public val sotCtxt: HciSOTContext? = null,
  public val trfRes: HciTariffResult? = null,
  public val ecoCmpL: List<HciEco> = emptyList(),
  public val msgL: List<HciMessage> = emptyList(),
  public val ovwTrfRefL: List<HciTariffRef> = emptyList(),
  public val parConL: List<HciConnection> = emptyList(),
  public val secL: List<HciConSection> = emptyList(),
  public val tcocXL: List<Int> = emptyList(),
  public val userL: List<HciUser> = emptyList(),
  public val combinedCount: Int = 0,
  public val conSubscr: HciConSubscriptionState = HciConSubscriptionState.U,
  public val dist: Int = 0,
  public val err: HciConnectionErrorType = HciConnectionErrorType.OK,
  public val intvlSubscr: HciIntvlSubscriptionState = HciIntvlSubscriptionState.U,
  public val originType: HciConnectionOriginType = HciConnectionOriginType.INITIAL,
  public val recState: HciReconstructionState = HciReconstructionState.U,
  public val resRecommendation: HciReservationRecommendation = HciReservationRecommendation.U,
  public val resState: HciReservationState = HciReservationState.U,
  public val sotRating: Int = 0,
  public val useableTime: Int = -1,
  public val ctxRecon: String? = null,
)
