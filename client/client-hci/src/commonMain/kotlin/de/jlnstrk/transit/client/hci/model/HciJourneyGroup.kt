package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciJourneyGroup(
    public val type: Type?,
    public val name: String?,
    public val icoX: Int?,
    public val grpItemL: List<HciJourneyGroupItem> = emptyList(),
    public val grpL: List<HciJourneyGroup> = emptyList(),
    public val msgL: List<HciMessage> = emptyList(),
) {

    @HciModel("1.39")
    @Serializable
    public enum class Type {
        CAT,
        DEST,
        DIR,
        HOUR,
        LINE,
        LW,
        NAME,
        ORIG,
        REG,
        ROOT,
        SERVICEDAYS,
        UNDEF,
    }
}