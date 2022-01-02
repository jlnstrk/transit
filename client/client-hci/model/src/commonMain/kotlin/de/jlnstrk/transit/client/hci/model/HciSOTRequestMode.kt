package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciSOTRequestMode {
  FROM_RECONSTRUCTION_VIA_EXTERNAL_DATA,
  FROM_RECONSTRUCTION_VIA_JOURNEYHANDLE,
  FROM_RECONSTRUCTION_VIA_SPOOL,
  FROM_SOTCONTEXT,
  NONE,
  STOP_TO_STOP,
  UNKNOWN,
}
