package de.jlnstrk.transit.api.hci.serializer

import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.request.HciRequestEnvelope
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.serializer

internal object HciRequestEnvelopeSerializer : KSerializer<HciRequestEnvelope> {
    override val descriptor: SerialDescriptor = HciRequestEnvelope.serializer().descriptor

    @OptIn(InternalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: HciRequestEnvelope) {
        val composite = encoder.beginStructure(descriptor)
        composite.encodeSerializableElement(
            descriptor,
            0,
            value.req::class.serializer() as KSerializer<HciServiceRequest<*>>,
            value.req
        )
        composite.encodeSerializableElement(descriptor, 1, HciServiceMethod.serializer(), value.meth)
        if (value.cfg != null) {
            composite.encodeSerializableElement(
                descriptor,
                2,
                HciRequestEnvelope.Configuration.serializer(),
                value.cfg
            )
        }
        composite.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): HciRequestEnvelope {
        throw UnsupportedOperationException()
    }
}