package de.jlnstrk.transit.client.hci.method.structgraph

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.struct.HciStructGraphInputReference
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciStructGraphServiceRequest(
  public var input: HciStructGraphInputReference? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciStructGraphServiceRequest.() -> Unit):
        HciStructGraphServiceRequest =
        de.jlnstrk.transit.client.hci.method.structgraph.HciStructGraphServiceRequest().apply(init)
  }
}
