package de.jlnstrk.transit.api.hafas

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class HafasHimSortOrder {
    @SerialName("EVT_BEG_ASC")
    EVENT_BEGINNING_ASC,

    @SerialName("EVG_BEG_DESC")
    EVENT_BEG_DESC,

    @SerialName("EVT_END_ASC")
    EVENT_END_ASC,

    @SerialName("EVT_END_DESC")
    EVENT_END_DESC,

    @SerialName("HID_ASC")
    HID_ASC,

    @SerialName("HID_DESC")
    HID_DESC,

    @SerialName("LMOD_ASC")
    LAST_MODIFICATION_ASC,

    @SerialName("LMOD_DESC")
    LAST_MODIFICATION_DESC,

    @SerialName("PRIO_ASC")
    PRIORITY_ASC,

    @SerialName("PRIO_DESC")
    PRIORITY_DESC,
}