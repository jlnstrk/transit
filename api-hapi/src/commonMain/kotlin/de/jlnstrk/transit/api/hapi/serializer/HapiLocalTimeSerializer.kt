package de.jlnstrk.transit.api.hapi.serializer

import com.soywiz.klock.format
import com.soywiz.klock.parseTime
import de.jlnstrk.transit.api.hapi.util.HAPI_LOCAL_TIME_FORMAT
import de.jlnstrk.transit.util.LocalTime
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
        return HAPI_LOCAL_TIME_FORMAT.parseTime(decoder.decodeString())
    }
}