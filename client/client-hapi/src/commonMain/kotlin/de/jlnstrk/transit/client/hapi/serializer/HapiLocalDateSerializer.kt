package de.jlnstrk.transit.client.hapi.serializer

import de.jlnstrk.transit.client.hapi.util.HAPI_LOCAL_DATE_FORMAT
import kotlinx.datetime.LocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object HapiLocalDateSerializer : KSerializer<LocalDate> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDate) {
        encoder.encodeString(HAPI_LOCAL_DATE_FORMAT.formatInstant(value))
    }

    override fun deserialize(decoder: Decoder): LocalDate {
        return HAPI_LOCAL_DATE_FORMAT.parseDate(decoder.decodeString())
    }
}