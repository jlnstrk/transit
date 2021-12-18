package de.jlnstrk.transit.client.hci.serializer

import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object HciLocationTypeSerializer : KSerializer<HciLocation.Type> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("HciLocation.Type", PrimitiveKind.STRING)
    private val VALUES = HciLocation.Type.values()

    override fun serialize(encoder: Encoder, value: HciLocation.Type) {
        encoder.encodeString(value.rawName())
    }

    override fun deserialize(decoder: Decoder): HciLocation.Type = decoder.decodeString().type()

    fun String.type(): HciLocation.Type = when (this) {
        "S", "ST" -> HciLocation.Type.STATION
        "A", "ADR" -> HciLocation.Type.ADDRESS
        "P", "POI" -> HciLocation.Type.POI
        "C" -> HciLocation.Type.COORD
        "MCP" -> HciLocation.Type.MCP
        "HL" -> HciLocation.Type.HAILING_POINT
        else -> throw IllegalArgumentException()
    }

    fun HciLocation.Type.rawName(): String = when (this) {
        HciLocation.Type.STATION -> "S"
        HciLocation.Type.ADDRESS -> "A"
        HciLocation.Type.POI -> "P"
        HciLocation.Type.HAILING_POINT -> "HL"
        HciLocation.Type.COORD -> "C"
        HciLocation.Type.MCP -> "MCP"
        else -> throw IllegalArgumentException()
    }

    internal object Set : KSerializer<kotlin.collections.Set<HciLocation.Type>> {
        override val descriptor: SerialDescriptor =
            PrimitiveSerialDescriptor("Set<HciLocation.Type>", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: kotlin.collections.Set<HciLocation.Type>) {
            val string = when (value.size) {
                VALUES.size -> "ALL"
                2 -> when {
                    value.contains(HciLocation.Type.STATION)
                            && value.contains(HciLocation.Type.ADDRESS) -> "SA"
                    value.contains(HciLocation.Type.STATION)
                            && value.contains(HciLocation.Type.POI) -> "SP"
                    value.contains(HciLocation.Type.ADDRESS)
                            && value.contains(HciLocation.Type.POI) -> "AP"
                    else -> throw IllegalArgumentException()
                }
                1 -> value.first().rawName()
                else -> throw IllegalStateException()
            }
            encoder.encodeString(string)
        }

        override fun deserialize(decoder: Decoder): kotlin.collections.Set<HciLocation.Type> {
            return when (val string = decoder.decodeString()) {
                "ALL" -> VALUES.toSet()
                "SA" -> setOf(HciLocation.Type.STATION, HciLocation.Type.ADDRESS)
                "SP" -> setOf(HciLocation.Type.STATION, HciLocation.Type.POI)
                "AP" -> setOf(HciLocation.Type.ADDRESS, HciLocation.Type.POI)
                else -> string.map(Char::toString)
                    .map { it.type() }
                    .toSet()
            }
        }
    }
}