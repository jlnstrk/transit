package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciConSectionType {
  BIKE,
  CHKI,
  CHKO,
  DEVI,
  DUMMY,
  JNY,
  KISS,
  PARK,
  TAXI,
  TETA,
  TRSF,
  WALK,
}
