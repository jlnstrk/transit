package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.OffsetDateTime

public data class DataHeader(
    public val calculationTime: OffsetDateTime? = null,
    public val realtimeReference: OffsetDateTime? = null,
    public val scheduleBegin: LocalDate? = null,
    public val scheduleEnd: LocalDate? = null,
    public val globalMessages: List<Message> = emptyList(),
    public val globalAttributes: List<Attribute> = emptyList()
)