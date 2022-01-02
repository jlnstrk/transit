package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciRealtimeDataSourceType {
  ARAMIS,
  BLACKLIST,
  DDS,
  DEFAULT,
  FE,
  FIS,
  GTFS,
  HIM,
  HRC,
  HRX,
  PAISA,
  SIRI,
  UIC,
  VDV,
}
