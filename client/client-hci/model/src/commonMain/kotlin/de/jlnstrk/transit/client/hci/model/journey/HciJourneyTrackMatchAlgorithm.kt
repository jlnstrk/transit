package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciJourneyTrackMatchAlgorithm {
  AUTO,
  BOTH,
  FIND_MY_RIDE,
  INVERSE,
  RTCM,
}
