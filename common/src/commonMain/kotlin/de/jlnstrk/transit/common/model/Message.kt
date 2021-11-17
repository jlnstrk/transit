package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.util.OffsetDateTime

public data class Message(
    public val head: String,
    public val isHtmlHead: Boolean = false,
    public val lead: String?,
    public val isHtmlLead: Boolean = false,
    public val body: String?,
    public val isHtmlBody: Boolean = false,
    public val priority: Priority,
    public val validFrom: OffsetDateTime? = null,
    public val validUntil: OffsetDateTime? = null,
    public val published: OffsetDateTime? = null,
    public val modified: OffsetDateTime? = null,
    public val expires: OffsetDateTime? = null,
    public val affectedProducts: ProductSet = ProductSet(),
    public val affectedLines: LineSet = LineSet(),
    public val affectedLocations: List<Location> = emptyList()
) {

    public enum class Priority {
        LOW, MEDIUM, HIGH
    }
}