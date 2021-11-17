package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.api.hci.model.journey.HciJourney
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import de.jlnstrk.transit.common.model.Journey
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext
import de.jlnstrk.transit.util.LocalDate

internal fun HciJourney.asCommon(context: HciCommonContext, tripDate: LocalDate?): Journey {
    val attributes = msgL
        .mapNotNull(HciMessage::remX)
        .map(context.attributes::get)
    val messages = msgL
        .mapNotNull(HciMessage::himX)
        .map(context.messages::get)
    return Journey(
        id = jid,
        line = context.lines[prodX],
        directionTo = Location.Station(dirTxt),
        stop = (stbStop ?: stopL.first()).asCommon(context, date ?: tripDate!!),
        stops = stopL.map { it.asCommon(context, date ?: tripDate!!) },
        messages = messages,
        attributes = attributes,
        polyline = polyG?.polyXL?.first()?.let(context.polylines::get),
        isReachable = isRchbl,
        isCancelled = isCncl,
        isPartiallyCancelled = isPartCncl
    )
}