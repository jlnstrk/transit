@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciEventLocation(
    public val locX: Int,
    public val eventX: Int,
    public val date: LocalDate?,
    public val time: LocalTime?,
)