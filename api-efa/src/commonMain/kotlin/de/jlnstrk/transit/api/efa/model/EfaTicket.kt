@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.model

import de.jlnstrk.transit.api.efa.serializer.generic.EfaMapListSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaTicket(
    public val net: String,
    public val fromPR: Int,
    public val toPR: Int,
    public val currency: String,
    public val weekAdult: Float?,
    public val weekChild: Float?,
    public val monthAdult: Float?,
    public val monthChild: Float?,
    public val weekEducation: Float?,
    public val monthEducation: Float?,
    public val yearAdults: Float?,
    public val yearChildren: Float?,
    public val yearStudents: Float?,
    public val dayAdults: Float?,
    public val dayChildren: Float?,
    public val dayStudents: Float?,
    public val levelAdult: String?,
    public val levelChild: String?,
    @Serializable(with = EfaMapListSerializer::class)
    public val genericTickets: Map<String, String> = emptyMap()
)