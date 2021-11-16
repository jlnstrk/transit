package de.jlnstrk.transit.api.efa.serializer.primitive.datetime

import com.soywiz.klock.format
import com.soywiz.klock.parseTime
import de.jlnstrk.transit.api.efa.util.EFA_TIME_FORMAT_NO_SEP
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object EfaSimpleTimeSerializer : KSerializer<LocalTime> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("EfaSimpleTime", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalTime) {
        val string = EFA_TIME_FORMAT_NO_SEP.format(value)
        encoder.encodeString(string)
    }

    override fun deserialize(decoder: Decoder): LocalTime {
        val string = decoder.decodeString().padStart(4, '0')
        return EFA_TIME_FORMAT_NO_SEP.parseTime(string)
    }
}