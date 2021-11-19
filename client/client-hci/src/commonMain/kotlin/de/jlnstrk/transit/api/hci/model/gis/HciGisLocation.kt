@file:UseSerializers(
    HciMinutesSerializer::class
)

package de.jlnstrk.transit.api.hci.model.gis

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.model.HciTransportMode
import de.jlnstrk.transit.api.hci.model.HciUsageType
import de.jlnstrk.transit.api.hci.model.location.HciMcpPlaceType
import de.jlnstrk.transit.api.hci.request.filter.HciGisFilter
import de.jlnstrk.transit.api.hci.serializer.time.HciMinutesSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciGisLocation(
    public val loc: HciLocation,
    public val locMode: Mode,
    public val mode: HciGisFilter.Mode,
    public val transportMode: HciTransportMode,
    public val usageType: HciUsageType,
    public val locDurationOfStay: Duration?,
    public val placeType: HciMcpPlaceType?,
) {

    @HciModel("1.39")
    @Serializable
    public enum class Mode {
        DEP,
        VIA,
        ARR,
        UNDEF
    }
}