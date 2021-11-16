package de.jlnstrk.transit.api.efa.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.jvm.JvmInline

internal class EfaInputUnwrapSerializer : KSerializer<String> {
    override val descriptor: SerialDescriptor = Input.serializer().descriptor

    @Serializable
    private class Input(val input: String)

    override fun serialize(encoder: Encoder, value: String) {
        Input.serializer().serialize(encoder, Input(value))
    }

    override fun deserialize(decoder: Decoder): String {
        return Input.serializer().deserialize(decoder).input
    }
}