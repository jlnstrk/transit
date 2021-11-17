package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.OffsetDateTime
import de.jlnstrk.transit.common.model.base.Identifiable

public data class NetworkMap(
    override val literalId: String,
    override val numericId: Long,
    public val title: String,
    public val place: String? = null,
    public val fileUrl: String? = null,
    public val author: String? = null,
    public val thumbnailUrl: String? = null,
    public val products: Set<ProductClass>? = null,
    public val published: OffsetDateTime? = null,
    public val modified: OffsetDateTime? = null,
    public val validFrom: LocalDate? = null,
    public val validTo: LocalDate? = null
) : Identifiable