package de.jlnstrk.transit.client.hci.model.share

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciShareMode {
  ICAL,
  LINK,
  MAIL,
  SMS,
  TEXT,
  TEXT_CAL,
  TEXT_SMS,
}
