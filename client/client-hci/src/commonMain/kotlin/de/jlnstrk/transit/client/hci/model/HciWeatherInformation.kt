@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciWeatherInformation(
    public val type: Type,
    public val date: LocalDate,
    public val time: LocalTime?,
    public val summary: String?,
    public val text: String?,
    public val icoX: Int?,
    public val msgL: List<HciMessage> = emptyList(),
) {

    @HciModel("1.39")
    @Serializable
    public enum class Type {
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
}