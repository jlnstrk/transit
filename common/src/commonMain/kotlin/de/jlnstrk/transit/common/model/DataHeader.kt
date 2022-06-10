package de.jlnstrk.transit.common.model

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate

public data class DataHeader(
    public val calculationTime: Instant? = null,
    public val realtimeReference: Instant? = null,
    public val scheduleBegin: LocalDate? = null,
    public val scheduleEnd: LocalDate? = null,
    public val globalMessages: List<Message> = emptyList(),
    public val globalAttributes: List<Attribute> = emptyList()
)