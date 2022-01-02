package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciWeatherType {
  CLEAR,
  CLOUDY,
  DRIZZLE,
  DRY,
  FOG,
  HAIL,
  HEAVY_FOG,
  HEAVY_HAIL,
  HEAVY_RAIN,
  HEAVY_SNOW,
  PARTIALLY_CLOUDY,
  RAIN,
  RAIN_SHOWER,
  SLEET,
  SLEET_SHOWER,
  SLIGHTLY_CLOUDY,
  SLIPPERY_ROAD,
  SNOW,
  SNOW_SHOWER,
  STORM,
  THUNDERSTORM,
  UNDEF,
  WET_AND_COLD,
}
