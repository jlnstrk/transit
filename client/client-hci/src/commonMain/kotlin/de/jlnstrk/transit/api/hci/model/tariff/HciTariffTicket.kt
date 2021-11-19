@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.api.hci.model.tariff

import de.jlnstrk.transit.api.hci.model.HciExternalContent
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class HciTariffTicket(
    public val addData: String? = null,
    public val cur: String? = null,
    public val desc: String? = null,
    public val destLocId: Int? = null,
    public val dtl: String? = null,
    public val extCont: HciExternalContent? = null,
    public val fSecRefL: Int? = null,
    public val fStopRefL: Int? = null,
    public val fValDate: LocalDate? = null,
    public val fValTime: LocalTime? = null,
    public val icoX: Int? = null,
    public val name: String? = null,
    public val outputName: String? = null,
    public val prc: Int? = null,
    public val price: HciTariffPrice? = null,
    public val shpCtx: String? = null,
    public val startLocId: Int? = null,
    public val tSecRefX: Int? = null,
    public val tStopRefX: Int? = null,
    public val tValDate: LocalDate? = null,
    public val tValTime: LocalTime? = null,
    public val typeKey: Int? = null,
    public val viaLocId: Int? = null,
)