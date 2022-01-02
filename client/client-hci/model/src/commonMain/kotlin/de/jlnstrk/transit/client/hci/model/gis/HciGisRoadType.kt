package de.jlnstrk.transit.client.hci.model.gis

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciGisRoadType {
  B,
  C,
  CT,
  CW,
  F,
  H,
  M,
  NT,
  R,
  T,
  @SerialName("T2L")
  T_2_L,
  @SerialName("T4L")
  T_4_L,
  TR,
  U,
  W,
}
