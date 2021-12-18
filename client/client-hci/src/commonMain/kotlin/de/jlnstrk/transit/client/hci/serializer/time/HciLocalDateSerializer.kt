package de.jlnstrk.transit.client.hci.serializer.time

import com.soywiz.klock.DateFormat
import com.soywiz.klock.format
import com.soywiz.klock.parseDate
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object HciLocalDateSerializer : KSerializer<LocalDate> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.STRING)
    private val DATE_FORMATTER = DateFormat("yyyyMMdd")

    override fun serialize(encoder: Encoder, value: LocalDate) {
        val string = DATE_FORMATTER.format(value)
        encoder.encodeString(string)
    }

    override fun deserialize(decoder: Decoder): LocalDate {
        val string = decoder.decodeString()
        return DATE_FORMATTER.parseDate(string)
    }
}