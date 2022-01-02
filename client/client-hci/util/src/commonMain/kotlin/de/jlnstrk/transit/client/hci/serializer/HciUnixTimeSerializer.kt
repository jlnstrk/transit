package de.jlnstrk.transit.client.hci.serializer

import de.jlnstrk.transit.util.LocalDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

// TODO: Inject provider timezone
public object HciUnixTimeSerializer : KSerializer<LocalDateTime> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalDateTime", PrimitiveKind.LONG)

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        encoder.encodeLong(value.unixMillisLong)
    }

    override fun deserialize(decoder: Decoder): LocalDateTime = LocalDateTime(decoder.decodeLong())
}