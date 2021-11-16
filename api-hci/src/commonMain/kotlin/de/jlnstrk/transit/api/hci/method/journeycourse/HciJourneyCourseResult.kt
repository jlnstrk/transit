@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.api.hci.method.journeycourse

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciPolylineGroup
import de.jlnstrk.transit.api.hci.model.geo.HciGeoRectangle
import de.jlnstrk.transit.api.hci.model.journey.HciJourney
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public class HciJourneyCourseResult(
    /** The date this result was calculated on */
    public val date: LocalDate,

    /** The time this result was calculated at */
    public val time: LocalTime,
    public val crdSysX: Int?,
    public val layerX: Int?,
    public val mainPoly: HciPolylineGroup?,
    public val rect: HciGeoRectangle?,
    public val edgePolys: List<HciPolylineGroup> = emptyList(),
    public val jnyL: List<HciJourney> = emptyList()
) : HciServiceResult()