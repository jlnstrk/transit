package de.jlnstrk.transit.common.model

import kotlinx.datetime.Instant


public data class Message(
    public val head: String,
    public val isHtmlHead: Boolean = false,
    public val lead: String?,
    public val isHtmlLead: Boolean = false,
    public val body: String?,
    public val isHtmlBody: Boolean = false,
    public val priority: Priority,
    public val validFrom: Instant? = null,
    public val validUntil: Instant? = null,
    public val published: Instant? = null,
    public val modified: Instant? = null,
    public val expires: Instant? = null,
    public val affectedProducts: ProductSet = ProductSet(),
    public val affectedLines: LineSet = LineSet(),
    public val affectedLocations: List<Location> = emptyList()
) {

    public enum class Priority {
        LOW, MEDIUM, HIGH
    }
}