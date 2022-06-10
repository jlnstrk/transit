package de.jlnstrk.transit.client.hci.method.partialsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciAntiViaLocation
import de.jlnstrk.transit.client.hci.model.HciPartialSearchInput
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
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciPartialSearchServiceRequest(
  public var bfAndroidEnd: String? = null,
  public var bfAndroidStart: String? = null,
  public var bfIOSEnd: String? = null,
  public var bfIOSStart: String? = null,
  public var ecoParams: HciEcoParams? = null,
  public var economic: Boolean? = null,
  public var einfachRaus: Boolean? = null,
  public var getAltCoordinates: Boolean? = null,
  public var getAnnotations: Boolean? = null,
  public var getEco: Boolean? = null,
  public var getEcoCmp: Boolean? = null,
  public var getIST: Boolean? = null,
  public var getLastPass: Boolean? = null,
  public var getPasslist: Boolean? = null,
  public var getPolyline: Boolean? = null,
  public var getSimpleTrainComposition: Boolean? = null,
  public var getTrainComposition: Boolean? = null,
  public var polySplitting: Boolean? = null,
  public var program: String? = null,
  public var psInput: HciPartialSearchInput? = null,
  public var trfReq: HciTariffRequest? = null,
  public var ushrp: Boolean? = null,
  public var antiViaLocL: List<HciAntiViaLocation> = emptyList(),
  public var gisFltrL: List<HciGisFilter> = emptyList(),
  public var gisLocL: List<HciGisLocation> = emptyList(),
  public var gisPrefLocL: List<HciGisPreferredLocation> = emptyList(),
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var prefLocL: List<HciLocation> = emptyList(),
  public var psOutReconL: List<HciReconstruction> = emptyList(),
  public var psRetReconL: List<HciReconstruction> = emptyList(),
  public var viaLocL: List<HciViaLocation> = emptyList(),
  public var cMZE: Int? = null,
  public var cTFS: Int? = null,
  public var extChgTime: Int? = null,
  public var getTariff: Boolean? = null,
  public var maxChg: Int? = null,
  public var maxChgTime: Int? = null,
  public var minChgTime: Int? = null,
  public var supplChgTime: Int? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciPartialSearchServiceRequest.() -> Unit):
        HciPartialSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.partialsearch.HciPartialSearchServiceRequest().apply(init)
  }
}
