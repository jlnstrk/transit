package de.jlnstrk.transit.common.service

import de.jlnstrk.transit.common.Service
import de.jlnstrk.transit.common.model.LineSet
import de.jlnstrk.transit.common.model.Message
import de.jlnstrk.transit.common.model.ProductClass

public interface StatusInformationService : Service {
    public val supportsFilterPriorities: Boolean get() = false
    public val supportsFilterProducts: Boolean get() = false
    public val supportsFilterLines: Boolean get() = false
    public val supportsMaxResults: Boolean get() = false

    public suspend fun statusInformation(
        filterPriorities: Set<Message.Priority>? = null,
        filterProducts: Set<ProductClass>? = null,
        filterLines: LineSet? = null,
        maxResults: Int? = null,
    ): StatusInformationResult

    public enum class Error
}