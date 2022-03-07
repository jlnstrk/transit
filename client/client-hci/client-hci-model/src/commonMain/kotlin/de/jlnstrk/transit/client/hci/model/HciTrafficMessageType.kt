package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciTrafficMessageType {
  AC,
  ACCIDENT,
  AT,
  BURNING_VEHICLE,
  CO,
  CONSTRUCTION_SITE,
  DANGER,
  DELAY,
  JUNCTION_CLOSED,
  LANE_CLOSED,
  OBSTRUCTION,
  RAIL_ROAD_CROSSING,
  RCLM,
  ROAD_CLOSED,
  RW,
  TRAFFIC_JAM,
  TRAFFIC_LIGHTS_DEFECT,
  U,
  WEATHER,
  WEATHER_HAIL,
  WEATHER_ICE,
  WEATHER_POOR_VISIBILITY,
  WEATHER_SNOW,
  WEATHER_WIND,
}
