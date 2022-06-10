package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.client.hci.model.him.HciHimMessage
import de.jlnstrk.transit.common.extensions.toLineSet
import de.jlnstrk.transit.common.extensions.toProductSet
import de.jlnstrk.transit.common.model.Message
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toInstant

internal fun HciHimMessage.asCommon(context: HciCommonContext): Message {
    return Message(
        head = head.orEmpty().ifEmpty { lead }.orEmpty(),
        isHtmlHead = false,
        lead = lead,
        isHtmlLead = false,
        body = text,
        isHtmlBody = false,
        validFrom = LocalDateTime(sDate!!, sTime!!.time)
            .toInstant(context.timezone),
        validUntil = LocalDateTime(eDate!!, eTime!!.time)
            .toInstant(context.timezone),
        modified = LocalDateTime(lModDate!!, lModTime!!.time)
            .toInstant(context.timezone),
        priority = when {
            prio > 66 -> Message.Priority.HIGH
            prio > 33 -> Message.Priority.MEDIUM
            else -> Message.Priority.LOW
        },
        affectedProducts = context.setFromBitmask(prod).toProductSet(),
        affectedLines = affProdRefL.map(context.lines::get).toLineSet(),
        affectedLocations = fLocX?.let {
            (it..(tLocX ?: (context.locations.size - 1))).map(context.locations::get)
        } ?: emptyList()
    )
}