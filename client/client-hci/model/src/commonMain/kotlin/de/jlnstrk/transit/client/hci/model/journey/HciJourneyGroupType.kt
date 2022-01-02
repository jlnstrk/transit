package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciJourneyGroupType {
  CAT,
  DEST,
  DIR,
  HOUR,
  LINE,
  LW,
  NAME,
  ORIG,
  REG,
  ROOT,
  SERVICEDAYS,
  UNDEF,
}
