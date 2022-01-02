package de.jlnstrk.transit.client.hci.method.locmatch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciLocMatchDataSource
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.location.HciLocationInput
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocMatchServiceRequest(
  public var cntry: String? = null,
  public var dts: HciLocMatchDataSource? = null,
  public var getProducts: Boolean? = null,
  public var input: HciLocationInput? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciLocMatchServiceRequest.() -> Unit):
        HciLocMatchServiceRequest =
        de.jlnstrk.transit.client.hci.method.locmatch.HciLocMatchServiceRequest().apply(init)
  }
}
