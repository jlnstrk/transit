package de.jlnstrk.transit.client.efa.serializer.primitive

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive

internal abstract class EfaPrimitiveSerializer<T>(
    protected val delegate: KSerializer<T>
) : KSerializer<T?> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("EmptyString", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: T?) {
        value?.let { delegate.serialize(encoder, it) } ?: encoder.encodeNull()
    }

    override fun deserialize(decoder: Decoder): T? {
        val string = decoder.decodeString()
        if (string.isEmpty())
            return null
        return Json.decodeFromJsonElement(delegate, JsonPrimitive(string))
    }

    internal object ForString :
        EfaPrimitiveSerializer<String>(String.serializer()) {
        private const val EMPTY_STATELESS = ":: : :"

        override fun deserialize(decoder: Decoder): String? {
            val string = delegate.deserialize(decoder)
            if (string.isBlank() || string == EMPTY_STATELESS)
                return null
            return string
        }
    }

    internal object ForInt :
        EfaPrimitiveSerializer<Int>(Int.serializer())

    internal object ForLong :
        EfaPrimitiveSerializer<Long>(Long.serializer())

    internal object ForFloat :
        EfaPrimitiveSerializer<Float>(Float.serializer())

    internal object ForDouble :
        EfaPrimitiveSerializer<Double>(Double.serializer())
}