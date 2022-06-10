package de.jlnstrk.transit.client.hci.serializer

import kotlinx.datetime.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object HciServiceDaysBitmaskSerializer : KSerializer<List<LocalDate>> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("List<LocalDate>", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: List<LocalDate>) {
        throw UnsupportedOperationException()
    }

    override fun deserialize(decoder: Decoder): List<LocalDate> {
        val string = decoder.decodeString()
        val bytes = string.chunked(2)
            .map { it.toInt(16).toByte() }
            .toByteArray()
        val dates = mutableListOf<LocalDate>()
        var day = 1
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        for (element in bytes) {
            for (i in 0..7) {
                if ((element.toInt() and (1 shl (7 - i))) > 0) {
                    dates.add(LocalDate(today.year, today.month, day))
                    day++
                }
            }
        }
        return dates
    }
}