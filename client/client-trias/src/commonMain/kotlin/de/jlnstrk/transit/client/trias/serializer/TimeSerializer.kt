package de.jlnstrk.transit.client.trias.serializer

import com.soywiz.klock.ISO8601
import com.soywiz.klock.format
import com.soywiz.klock.parseTime
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializer(forClass = LocalTime::class)
public object TimeSerializer : KSerializer<LocalTime> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Time", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalTime) {
        return encoder.encodeString(ISO8601.TIME.format(value))
    }

    override fun deserialize(decoder: Decoder): LocalTime {
        return ISO8601.TIME.parseTime(decoder.decodeString())
    }
}