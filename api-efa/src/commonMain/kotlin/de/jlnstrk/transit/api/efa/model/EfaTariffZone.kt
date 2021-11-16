@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.model

import de.jlnstrk.transit.api.efa.serializer.generic.EfaOptionalListSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaTariffZone(
    public val net: String,
    public val fromPR: Int,
    public val toPR: Int,
    public val neutralZone: String?,
    @Serializable(with = EfaOptionalListSerializer::class)
    public val zones: List<Zone> = emptyList()
) {

    @Serializable
    public class Zone(
        @Serializable(with = EfaOptionalListSerializer::class)
        public val zoneElems: List<Element>
    ) {

        @Serializable
        public class Element(public val zone: String)
    }
}