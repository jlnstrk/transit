@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.model

import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaNestedObjectDateTimeSerializer
import de.jlnstrk.transit.util.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaPeriod(
    @Serializable(with = EfaNestedObjectDateTimeSerializer::class)
    public val itdDateTime_From: LocalDateTime,

    @Serializable(with = EfaNestedObjectDateTimeSerializer::class)
    public val itdDateTime_To: LocalDateTime
)