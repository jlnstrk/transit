package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciSubscrStatus {
  ACTIVE,
  DEACTIVATED_BY_USER,
  END_OF_MONITORING,
  EXPIRED,
  INCOMP,
  INVALID,
  MONITORING,
  NONE,
  NOT_MATCHING,
  SNOOZED_TODAY,
  TODAY_NOT_OBSERVED,
}
