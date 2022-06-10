package de.jlnstrk.transit.client.hci.serializer

import de.jlnstrk.transit.util.DateFormat
import kotlinx.datetime.LocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object HciLocalDateSerializer : KSerializer<LocalDate> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.STRING)
    private val DATE_FORMATTER = DateFormat("yyyyMMdd")

    override fun serialize(encoder: Encoder, value: LocalDate) {
        val string = DATE_FORMATTER.formatDate(value)
        encoder.encodeString(string)
    }

    override fun deserialize(decoder: Decoder): LocalDate {
        val string = decoder.decodeString()
        return DATE_FORMATTER.parseDate(string)
    }
}