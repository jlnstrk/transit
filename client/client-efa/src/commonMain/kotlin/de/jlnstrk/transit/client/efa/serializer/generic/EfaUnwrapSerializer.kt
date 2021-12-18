package de.jlnstrk.transit.client.efa.serializer.generic

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal abstract class EfaUnwrapSerializer<T>(
    private val delegate: KSerializer<T>
) : KSerializer<T> {
    override val descriptor: SerialDescriptor = delegate.descriptor

    override fun serialize(encoder: Encoder, value: T) {
        delegate.serialize(encoder, value)
    }

    override fun deserialize(decoder: Decoder): T {
        val composite = decoder.beginStructure(descriptor)
        val nested = composite.decodeSerializableElement(delegate.descriptor, 0, delegate)
        composite.endStructure(descriptor)
        return nested
    }

    object String : EfaUnwrapSerializer<kotlin.String>(kotlin.String.serializer())
}