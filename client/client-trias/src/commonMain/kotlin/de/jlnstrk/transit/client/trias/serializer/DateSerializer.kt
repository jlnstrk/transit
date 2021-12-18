package de.jlnstrk.transit.client.trias.serializer

import com.soywiz.klock.ISO8601
import com.soywiz.klock.format
import com.soywiz.klock.parseDate
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializer(forClass = LocalDate::class)
public object DateSerializer : KSerializer<LocalDate> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDate) {
        return encoder.encodeString(ISO8601.DATE.format(value))
    }

    override fun deserialize(decoder: Decoder): LocalDate {
        return ISO8601.DATE.parseDate(decoder.decodeString())
    }
}