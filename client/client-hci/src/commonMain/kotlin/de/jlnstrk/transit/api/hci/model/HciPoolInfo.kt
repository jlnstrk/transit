@file:UseSerializers(
    HciLocalDateSerializer::class
)

package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciPoolInfo(
    public val uic: Int,
    public val index: Int,
    public val subType: HciLocation.Type?,
    public val beginDate: LocalDate?,
    public val endDate: LocalDate?,
    public val timestamp: Long?,
)