package de.jlnstrk.transit.client.hci.model.rating

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciRatingKey {
  A,
  C,
  P,
  S,
  T,
}