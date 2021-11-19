package de.jlnstrk.transit.api.hci.model.journey

import de.jlnstrk.transit.api.hci.model.*
import de.jlnstrk.transit.api.hci.model.geo.HciCoord
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import de.jlnstrk.transit.api.hci.serializer.time.HciDurationSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.Serializable

@Serializable
public data class HciJourney(
    public val jid: String,

    public val prodX: Int,

    @Serializable(with = HciLocalDateSerializer::class)
    public val date: LocalDate?,

    public val dirTxt: String,

    public val dirFlg: String?,

    public val status: String?,

    public val isCncl: Boolean = false,

    public val isPartCncl: Boolean = false,

    public val polyG: HciPolylineGroup?,

    public val msgL: List<HciMessage> = emptyList(),

    public val subscr: String?,

    public val prodL: List<Product> = emptyList(),

    public val dirL: List<Direction> = emptyList(),

    public val stopL: List<HciStop> = emptyList(),

    public val stbStop: HciStop?,

    public val isRchbl: Boolean = true,

    public val freq: HciFrequency?,

    public val pos: HciCoord?,

    public val ctxRecon: String?,

    // TODO: Meaning?
    public val chgDurR: Int?,

    public val dist: Int?,

    // TODO: Redir = Redirection?
    public val isRedir: Boolean?,

    // TODO: Purpose?
    public val chRatingSoll: Int?,

    // TODO: Purpose?
    public val sumLDrawStyleX: Int?,

    // TODO: Purpose?
    public val resLDrawStyleX: Int?,

    @Serializable(with = HciLocalDateSerializer::class)
    public val trainStartDate: LocalDate?,

    // TODO: Purpose?
    @Serializable(with = HciDurationSerializer::class)
    public val durS: Duration?,

    // TODO: Name?
    public val tcocXL: List<Int> = emptyList(),

    public val sDaysL: List<HciServiceDays> = emptyList(),

    public val dirGeo: Int?,

    public val proc: Int?,

    public val isBase: Boolean?,
) {

    @Serializable
    public data class Product(
        public val prodX: Int,

        public val fLocX: Int,

        public val tLocX: Int,

        public val fIdx: Int,

        public val tIdx: Int
    )

    @Serializable
    public data class Direction(
        public val dirX: Int,

        public val fLocX: Int,

        public val tLocX: Int,

        public val fIdx: Int,

        public val tIdx: Int
    )
}