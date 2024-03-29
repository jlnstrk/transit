@file:UseSerializers(
    HapiLocalDateSerializer::class
)

package de.jlnstrk.transit.api.hapi.response

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.HapiOperator
import de.jlnstrk.transit.api.hapi.model.HapiProduct
import de.jlnstrk.transit.api.hapi.model.HapiProductCategory
import de.jlnstrk.transit.api.hapi.response.base.HapiResponse
import de.jlnstrk.transit.api.hapi.serializer.HapiLocalDateSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

/** Contains information about master data. */
@HapiXsd("1.29")
@Serializable
public class HapiDataInfo(
    public val Operator: List<HapiOperator> = emptyList(),
    public val Product: List<HapiProduct> = emptyList(),
    public val ProductCategory: List<HapiProductCategory> = emptyList(),
    public val begin: LocalDate,
    public val end: LocalDate,
) : HapiResponse()