package de.jlnstrk.transit.client.hci.model.connection

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciConnectionErrorType {
  EXP,
  OK,
  OK_LATE,
  RCF,
  REM,
  WARN,
}