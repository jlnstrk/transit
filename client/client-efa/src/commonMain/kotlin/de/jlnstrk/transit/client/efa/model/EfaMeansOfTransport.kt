@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.model

import de.jlnstrk.transit.client.efa.request.convert.EfaIntEnum
import de.jlnstrk.transit.client.efa.serializer.EfaMeansSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable(with = EfaMeansSerializer::class)
public enum class EfaMeansOfTransport : EfaIntEnum.Maskable {
    TRAIN,
    COMMUTER_RAILWAY,
    SUBWAY,
    CITY_RAIL,
    TRAM,
    CITY_BUS,
    REGIONAL_BUS,
    EXPRESS_BUS,
    CABLE_CAR,
    FERRY,
    TAXI_ON_DEMAND,
    OTHER,
    AIRPLANE,
    TRAIN_LOCAL,
    TRAIN_INTERCITY,
    TRAIN_INTERCITY_SURCHARGE,
    TRAIN_INTERCITY_SPECIAL_FARE,
    REPLACEMENT_SERVICE,
    RAIL_SHUTTLE,
    CIVIL_BUS;

    internal companion object :
        EfaIntEnum.Maskable.Companion<EfaMeansOfTransport>(EfaMeansOfTransport::class)
}