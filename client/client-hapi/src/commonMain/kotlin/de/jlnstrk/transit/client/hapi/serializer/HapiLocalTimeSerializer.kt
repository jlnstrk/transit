package de.jlnstrk.transit.client.hapi.serializer

import de.jlnstrk.transit.client.hapi.util.HAPI_LOCAL_TIME_FORMAT
import kotlinx.datetime.LocalTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object HapiLocalTimeSerializer : KSerializer<LocalTime> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("LocalTime", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalTime) {
        encoder.encodeString(HAPI_LOCAL_TIME_FORMAT.format(value))
    }

    override fun deserialize(decoder: Decoder): LocalTime {
        return HAPI_LOCAL_TIME_FORMAT.parse(decoder.decodeString())
    }
}