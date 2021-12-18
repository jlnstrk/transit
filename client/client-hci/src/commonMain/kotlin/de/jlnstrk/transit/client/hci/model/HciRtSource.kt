package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciRtSource(
    public val type: Type?,
    public val name: String?,
    public val freeTextIdCount: Int?,
    public val heartBeatTS: String?,
) {

    @HciModel("1.39")
    @Serializable
    public enum class Type {
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
}