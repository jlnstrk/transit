package de.jlnstrk.transit.client.hci.model.gis

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciGisType {
  B,
  F,
  K,
  P,
  T,
  TE,
  U,
}
