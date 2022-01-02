package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciJourneyTrainPosMode {
  CALC,
  CALC_FOR_REPORT,
  CALC_FOR_REPORT_START,
  CALC_ONLY,
  CALC_REPORT,
  REPORT_ONLY,
  REPORT_ONLY_WITH_STOPS,
}
