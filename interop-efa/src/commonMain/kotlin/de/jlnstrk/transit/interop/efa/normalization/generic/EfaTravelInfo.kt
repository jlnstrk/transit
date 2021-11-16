package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.api.efa.model.EfaTravelInfo
import de.jlnstrk.transit.util.OffsetDateTime
import de.jlnstrk.transit.util.extensions.toLineSet
import de.jlnstrk.transit.util.model.Message
import de.jlnstrk.transit.interop.efa.EfaProvider

internal fun EfaTravelInfo.normalize(provider: EfaProvider): Message {
    return Message(
        head = infoLink.first().subtitle ?: infoLink.first().infoLinkText.orEmpty(),
        subhead = infoLink.first().subtitle,
        body = infoLink.first().content.orEmpty(),
        priority = when (priority) {
            EfaTravelInfo.Priority.VERY_LOW -> Message.Priority.LOW
            EfaTravelInfo.Priority.LOW -> Message.Priority.LOW
            EfaTravelInfo.Priority.NORMAL -> Message.Priority.MEDIUM
            EfaTravelInfo.Priority.HIGH,
            EfaTravelInfo.Priority.VERY_HIGH,
            EfaTravelInfo.Priority.THREE -> Message.Priority.HIGH
        },
        published = OffsetDateTime.local(creationTime, provider.timezone),
        validFrom = OffsetDateTime.local(publicationDuration.itdDateTime_From, provider.timezone),
        validUntil = OffsetDateTime.local(publicationDuration.itdDateTime_To, provider.timezone),
        lines = concernedLines?.map { it.normalize(provider) }?.toLineSet()
    )
}