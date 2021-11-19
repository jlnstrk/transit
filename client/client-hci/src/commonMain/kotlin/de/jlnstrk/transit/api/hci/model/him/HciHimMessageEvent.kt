@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.api.hci.model.him

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciHimMessageEvent(
    public val fDate: LocalDate,
    public val fTime: LocalTime,
    public val fLocX: Int?,
    public val tDate: LocalDate,
    public val tTime: LocalTime,
    public val tLocX: Int?,
    public val isCurrent: Boolean = false,
    public val sectionNums: List<String> = emptyList(),
)