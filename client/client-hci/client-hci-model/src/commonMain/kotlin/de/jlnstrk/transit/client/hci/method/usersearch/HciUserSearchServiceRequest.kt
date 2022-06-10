package de.jlnstrk.transit.client.hci.method.usersearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.user.HciUser
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciUserSearchServiceRequest(
  public var userL: List<HciUser> = emptyList(),
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciUserSearchServiceRequest.() -> Unit):
        HciUserSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.usersearch.HciUserSearchServiceRequest().apply(init)
  }
}
