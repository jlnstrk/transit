package de.jlnstrk.transit.client.efa.serializer

import de.jlnstrk.transit.client.efa.model.EfaMeansOfTransport
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object EfaMeansSerializer : KSerializer<EfaMeansOfTransport> {
    override val descriptor: SerialDescriptor = String.serializer().descriptor
    private val config: Array<EfaMeansOfTransport> = EfaMeansOfTransport.values()

    override fun serialize(encoder: Encoder, value: EfaMeansOfTransport) {
        value.let(EfaMeansOfTransport::ordinal)
            .let(Int::toString)
            .let(encoder::encodeString)
    }

    override fun deserialize(decoder: Decoder): EfaMeansOfTransport {
        val ordinal = decoder.decodeString().toInt()
        return deserialize(ordinal) ?: EfaMeansOfTransport.OTHER
    }

    fun deserialize(ordinal: Int): EfaMeansOfTransport? {
        return if (ordinal < 0 || ordinal >= config.size) null else config[ordinal]
    }

    object Set : KSerializer<kotlin.collections.Set<EfaMeansOfTransport>> {
        override val descriptor: SerialDescriptor = String.serializer().descriptor

        override fun serialize(
            encoder: Encoder,
            value: kotlin.collections.Set<EfaMeansOfTransport>
        ) {
            val string = value.map(EfaMeansOfTransport::ordinal)
                .joinToString(separator = ", ")
            encoder.encodeString(string)
        }

        override fun deserialize(decoder: Decoder): kotlin.collections.Set<EfaMeansOfTransport> {
            val value = decoder.decodeString()
            val set = mutableSetOf<EfaMeansOfTransport>()
            val ordinals = value.split(',')
            for (ordinal in ordinals) {
                val means = deserialize(ordinal.toInt())
                set.add(means ?: continue)
            }
            return set
        }
    }
}