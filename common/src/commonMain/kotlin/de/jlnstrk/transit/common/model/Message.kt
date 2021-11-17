package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.util.OffsetDateTime

public data class Message(
    public val head: String,
    public val body: String,
    public val subhead: String?,
    public val priority: Priority,
    public val validFrom: OffsetDateTime,
    public val validUntil: OffsetDateTime,
    public val published: OffsetDateTime? = null,
    public val modified: OffsetDateTime? = null,
    public val expires: OffsetDateTime? = null,
    public val products: Set<ProductClass>? = null,
    public val lines: LineSet? = null,
    public val isHtmlTitle: Boolean = false,
    public val isHtmlSubtitle: Boolean = false,
    public val isHtmlBody: Boolean = false
) {

    public enum class Priority {
        LOW, MEDIUM, HIGH
    }
}