@file:UseSerializers(
    HciDurationSerializer::class
)

package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.serializer.time.HciDurationSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciPreselectionEdge(
    public val cost: Int?,
    public val dist: Int?,
    public val dur: Duration?,
    public val id: String?,
    public val speed: Int?,
    public val value: Int?,
)