package de.jlnstrk.transit.client.hci.method.reconstruction

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.eco.HciEcoParams
import de.jlnstrk.transit.client.hci.model.recon.HciReconstruction
import de.jlnstrk.transit.client.hci.model.recon.HciReconstructionSettings
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffRequest
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciReconstructionServiceRequest(
  public var bfAndroidEnd: String? = null,
  public var bfAndroidStart: String? = null,
  public var bfIOSEnd: String? = null,
  public var bfIOSStart: String? = null,
  public var ecoParams: HciEcoParams? = null,
  public var getAltCoordinates: Boolean? = null,
  public var getAnnotations: Boolean? = null,
  public var getEco: Boolean? = null,
  public var getEcoCmp: Boolean? = null,
  public var getIST: Boolean? = null,
  public var getLastPass: Boolean? = null,
  public var getPasslist: Boolean? = null,
  public var getPolyline: Boolean? = null,
  public var getRouteXml: Boolean? = null,
  public var getSimpleTrainComposition: Boolean? = null,
  public var getTariff: Boolean? = null,
  public var getTrafficMsg: Boolean? = null,
  public var getTrainComposition: Boolean? = null,
  public var polySplitting: Boolean? = null,
  public var program: String? = null,
  public var reconSettings: HciReconstructionSettings? = null,
  public var storageId: String? = null,
  public var trfReq: HciTariffRequest? = null,
  public var outReconL: List<HciReconstruction> = emptyList(),
  public var retReconL: List<HciReconstruction> = emptyList(),
  public var cMZE: Int? = null,
  public var cTFS: Int? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciReconstructionServiceRequest.() -> Unit):
        HciReconstructionServiceRequest =
        de.jlnstrk.transit.client.hci.method.reconstruction.HciReconstructionServiceRequest().apply(init)
  }
}
