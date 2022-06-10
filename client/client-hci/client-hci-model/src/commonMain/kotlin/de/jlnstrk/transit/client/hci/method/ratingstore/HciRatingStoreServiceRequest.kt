package de.jlnstrk.transit.client.hci.method.ratingstore

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.rating.HciRating
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciRatingStoreServiceRequest(
  public var rating: HciRating? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciRatingStoreServiceRequest.() -> Unit):
        HciRatingStoreServiceRequest =
        de.jlnstrk.transit.client.hci.method.ratingstore.HciRatingStoreServiceRequest().apply(init)
  }
}
