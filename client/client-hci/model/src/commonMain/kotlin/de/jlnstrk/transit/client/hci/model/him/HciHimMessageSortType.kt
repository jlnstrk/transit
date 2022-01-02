package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciHimMessageSortType {
  EVT_BEG_ASC,
  EVT_BEG_DESC,
  EVT_END_ASC,
  EVT_END_DESC,
  HID_ASC,
  HID_DESC,
  LMOD_ASC,
  LMOD_DESC,
  PRIO_ASC,
  PRIO_DESC,
}
