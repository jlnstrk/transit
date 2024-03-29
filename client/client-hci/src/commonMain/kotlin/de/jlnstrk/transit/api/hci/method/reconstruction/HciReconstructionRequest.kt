package de.jlnstrk.transit.api.hci.method.reconstruction

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.model.eco.HciEcoParams
import de.jlnstrk.transit.api.hci.model.recon.HciReconstruction
import de.jlnstrk.transit.api.hci.model.recon.HciReconstructionSettings
import de.jlnstrk.transit.api.hci.model.tariff.HciTariffRequest
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciReconstructionRequest(
    public var bfAndroidEnd: String? = null,
    public var bfAndroidStart: String? = null,
    public var bfIOSEnd: String? = null,
    public var bfIOSStart: String? = null,
    public var cMZE: Int? = null,
    public var cTFS: Int? = null,
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
    public var outReconL: List<HciReconstruction> = emptyList(),
    public var polySplitting: Boolean? = null,
    public var program: String? = null,
    public var reconSettings: HciReconstructionSettings? = null,
    public var retReconL: List<HciReconstruction> = emptyList(),
    public var storageId: String? = null,
    public var trfReq: HciTariffRequest? = null,
) : HciServiceRequest<HciReconstructionResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.RECONSTRUCTION

    public companion object {
        public inline operator fun invoke(init: HciReconstructionRequest.() -> Unit): HciReconstructionRequest =
            HciReconstructionRequest().apply(init)
    }
}