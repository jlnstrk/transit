package de.jlnstrk.transit.client.hci.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class HciPolylineGroup(
    public val polyXL: IntArray,

    public val crdSysX: Int?,

    public val layerX: Int?
)