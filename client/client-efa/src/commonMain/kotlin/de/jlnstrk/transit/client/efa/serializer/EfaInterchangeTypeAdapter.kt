package de.jlnstrk.transit.client.efa.serializer

import de.jlnstrk.transit.client.efa.model.EfaMode
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object EfaInterchangeTypeAdapter : KSerializer<EfaMode.InterchangeType> {
    override val descriptor: SerialDescriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: EfaMode.InterchangeType) {
        val code = when (value) {
            EfaMode.InterchangeType.DoNotChange -> "97"
            EfaMode.InterchangeType.SecureConnection -> "98"
            EfaMode.InterchangeType.Footway -> "99"
            EfaMode.InterchangeType.Transfer -> "105"
            is EfaMode.InterchangeType.Icon -> value.type.toString()
            else -> throw IllegalArgumentException()
        }
        encoder.encodeString(code)
    }

    override fun deserialize(decoder: Decoder): EfaMode.InterchangeType {
        return when (val code = decoder.decodeString()) {
            "97" -> EfaMode.InterchangeType.DoNotChange
            "98" -> EfaMode.InterchangeType.SecureConnection
            "99" -> EfaMode.InterchangeType.Footway
            "105" -> EfaMode.InterchangeType.Transfer
            else -> EfaMode.InterchangeType.Icon(code.toInt())
        }
    }
}