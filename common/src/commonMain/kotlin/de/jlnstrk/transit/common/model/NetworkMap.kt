package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.common.model.base.Identifiable
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate

public data class NetworkMap(
    override val id: String,
    public val title: String,
    public val place: String? = null,
    public val fileUrl: String? = null,
    public val author: String? = null,
    public val thumbnailUrl: String? = null,
    public val products: Set<ProductClass>? = null,
    public val published: Instant? = null,
    public val modified: Instant? = null,
    public val validFrom: LocalDate? = null,
    public val validTo: LocalDate? = null
) : Identifiable