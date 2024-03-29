package de.jlnstrk.transit.interop.hci.conversion

import com.soywiz.klock.DateTime
import de.jlnstrk.transit.api.hci.model.him.HciHimMessage
import de.jlnstrk.transit.common.extensions.toLineSet
import de.jlnstrk.transit.common.extensions.toProductSet
import de.jlnstrk.transit.common.model.Message
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal fun HciHimMessage.asCommon(context: HciCommonContext): Message {
    return Message(
        head = head.orEmpty().ifEmpty { lead }.orEmpty(),
        isHtmlHead = false,
        lead = lead,
        isHtmlLead = false,
        body = text,
        isHtmlBody = false,
        validFrom = DateTime(sDate, sTime)
            .toOffsetUnadjusted(context.timezone),
        validUntil = DateTime(eDate, eTime)
            .toOffsetUnadjusted(context.timezone),
        modified = DateTime(lModDate, lModTime)
            .toOffsetUnadjusted(context.timezone),
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