package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciStationBoardType {
  ARR,
  ARR_EQUIVS,
  ARR_MAST,
  ARR_STATION,
  DEP,
  DEP_EQUIVS,
  DEP_MAST,
  DEP_STATION,
}
