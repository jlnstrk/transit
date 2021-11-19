package de.jlnstrk.transit.api.trias.serializer

import com.soywiz.klock.ISO8601
import com.soywiz.klock.format
import com.soywiz.klock.parseUtc
import de.jlnstrk.transit.util.LocalDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializer(forClass = LocalDateTime::class)
public object DateTimeSerializer : KSerializer<LocalDateTime> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("DateTime", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        return encoder.encodeString(ISO8601.DATE.format(value))
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        return ISO8601.DATE.parseUtc(decoder.decodeString())
    }
}