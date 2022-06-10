package de.jlnstrk.transit.client.hci.method.reconstructioncontextconverter

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.recon.HciReconstructionContextConvertMode
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciReconstructionContextConverterServiceRequest(
  public var ctxL: List<String> = emptyList(),
  public var mode: HciReconstructionContextConvertMode? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator
        fun invoke(`init`: HciReconstructionContextConverterServiceRequest.() -> Unit):
        HciReconstructionContextConverterServiceRequest =
        de.jlnstrk.transit.client.hci.method.reconstructioncontextconverter.HciReconstructionContextConverterServiceRequest().apply(init)
  }
}
