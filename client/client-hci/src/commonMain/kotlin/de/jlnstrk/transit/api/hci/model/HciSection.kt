package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hci.model.HciSection.Type
import de.jlnstrk.transit.api.hci.model.gis.HciGis
import de.jlnstrk.transit.api.hci.model.journey.HciJourney
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import de.jlnstrk.transit.api.hci.serializer.time.HciDurationSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.Serializable

@Serializable
public data class HciSection(
    /** This section's departure stop */
    public val dep: HciStop,
    /** This section's arrival stop */
    public val arr: HciStop,
    /** The icon associated with this section */
    public val icoX: Int?,
    /** The type of this section */
    public val type: Type,
    /** The journey of this section, in case [type] equals [Type.JNY] */
    public val jny: HciJourney?,
    // TODO: Purpose?
    @Serializable(with = HciDurationSerializer::class)
    public val minChg: Duration?,
    /** The messages associated with this section */
    public val msgL: List<HciMessage> = emptyList(),
    /** The GIS route of this section, in case [type] is one of
     * [Type.WALK], [Type.BIKE], [Type.KISS], [Type.TAXI], [Type.TETA], [Type.PARK] */
    public val gis: HciGis?,
    /** Whether this section shall be hidden from the UI */
    public val hide: Boolean?
) {

    @Serializable
    public enum class Type {
        JNY,
        TRSF,
        WALK,
        BIKE,
        KISS,
        TAXI,
        TETA,
        PARK
    }
}