package de.jlnstrk.transit.client.hci.model.client

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciClientType {
  @SerialName("")
  _EMPTY_,
  AND,
  API,
  BB,
  HIM,
  IPA,
  IPH,
  IPW,
  WEB,
  WPH,
}
