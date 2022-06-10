package de.jlnstrk.transit.client.hci.method.tripsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciAntiViaLocation
import de.jlnstrk.transit.client.hci.model.HciChangeTimeProfile
import de.jlnstrk.transit.client.hci.model.HciPTSearchMode
import de.jlnstrk.transit.client.hci.model.HciRoutingPreselection
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.HciViaLocation
import de.jlnstrk.transit.client.hci.model.eco.HciEcoParams
import de.jlnstrk.transit.client.hci.model.gis.HciGisFilter
import de.jlnstrk.transit.client.hci.model.gis.HciGisLocation
import de.jlnstrk.transit.client.hci.model.gis.HciGisPreferredLocation
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.model.recon.HciReconstruction
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffRequest
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTripSearchServiceRequest(
  public var baim: Boolean? = null,
  public var bfAndroidEnd: String? = null,
  public var bfAndroidStart: String? = null,
  public var bfIOSEnd: String? = null,
  public var bfIOSStart: String? = null,
  public var ctxScr: String? = null,
  public var disableDurOpt: Boolean? = null,
  public var ecoParams: HciEcoParams? = null,
  public var economic: Boolean? = null,
  public var einfachRaus: Boolean? = null,
  public var freq: Int? = null,
  public var getAltCoordinates: Boolean? = null,
  public var getAnnotations: Boolean? = null,
  public var getEco: Boolean? = null,
  public var getEcoCmp: Boolean? = null,
  public var getIST: Boolean? = null,
  public var getIV: Boolean? = null,
  public var getLastPass: Boolean? = null,
  public var getPT: Boolean? = null,
  public var getPasslist: Boolean? = null,
  public var getPolyline: Boolean? = null,
  public var getSimpleTrainComposition: Boolean? = null,
  public var getTariff: Boolean? = null,
  public var getTrafficMsg: Boolean? = null,
  public var getTrainComposition: Boolean? = null,
  public var indoor: Boolean? = null,
  public var liveSearch: Boolean? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var outDate: LocalDate? = null,
  public var outFrwd: Boolean? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var outTime: HciLocalTime? = null,
  public var periodCombineDep: Boolean? = null,
  public var polySplitting: Boolean? = null,
  public var program: String? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var retDate: LocalDate? = null,
  public var retFrwd: Boolean? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var retTime: HciLocalTime? = null,
  public var searchContext: HciReconstruction? = null,
  public var trfReq: HciTariffRequest? = null,
  public var ushrp: Boolean? = null,
  public var withICTAlternatives: Boolean? = null,
  public var antiViaLocL: List<HciAntiViaLocation> = emptyList(),
  public var arrLocL: List<HciLocation> = emptyList(),
  public var backPreselectionL: List<HciRoutingPreselection> = emptyList(),
  public var depLocL: List<HciLocation> = emptyList(),
  public var frontPreselectionL: List<HciRoutingPreselection> = emptyList(),
  public var gisFltrL: List<HciGisFilter> = emptyList(),
  public var gisLocL: List<HciGisLocation> = emptyList(),
  public var gisPrefLocL: List<HciGisPreferredLocation> = emptyList(),
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var outReconL: List<HciReconstruction> = emptyList(),
  public var prefLocL: List<HciLocation> = emptyList(),
  public var retReconL: List<HciReconstruction> = emptyList(),
  public var viaLocL: List<HciViaLocation> = emptyList(),
  public var cFGZ: Int? = null,
  public var cFLZ: Int? = null,
  public var cMZE: Int? = null,
  public var cNRA: Int? = null,
  public var cNUH: Int? = null,
  public var cNUMH: Int? = null,
  public var cNVOR: Int? = null,
  public var cOFFERR: Int? = null,
  public var cRFRA: Int? = null,
  public var cTFS: Int? = null,
  public var cVLKURZ: Int? = null,
  public var cVLMITTEL: Int? = null,
  public var chgTimeProfile: HciChangeTimeProfile? = null,
  public var extChgTime: Int? = null,
  public var maxChg: Int? = null,
  public var maxChgTime: Int? = null,
  public var minChgTime: Int? = null,
  public var numB: Int? = null,
  public var numF: Int? = null,
  public var outPeriod: Int? = null,
  public var period: Int? = null,
  public var periodMaxCons: Int? = null,
  public var pt: HciPTSearchMode? = null,
  public var retPeriod: Int? = null,
  public var supplChgTime: Int? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciTripSearchServiceRequest.() -> Unit):
        HciTripSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.tripsearch.HciTripSearchServiceRequest().apply(init)
  }
}
