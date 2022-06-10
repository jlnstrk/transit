@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.model

import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.datetime.EfaNestedObjectDateTimeSerializer
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaPeriod(
    @Serializable(with = EfaNestedObjectDateTimeSerializer::class)
    public val itdDateTime_From: LocalDateTime,

    @Serializable(with = EfaNestedObjectDateTimeSerializer::class)
    public val itdDateTime_To: LocalDateTime
)