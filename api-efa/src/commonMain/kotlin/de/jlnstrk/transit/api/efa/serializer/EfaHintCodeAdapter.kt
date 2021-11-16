package de.jlnstrk.transit.api.efa.serializer

import de.jlnstrk.transit.api.efa.model.EfaHint
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object EfaHintCodeAdapter : KSerializer<EfaHint.Code?> {
    override val descriptor: SerialDescriptor = String.serializer().descriptor
    private val MAP: Map<String, EfaHint.Code> = HashMap()

    init {
        MAP as MutableMap
        MAP["FK"] = EfaHint.Code.BICYCLE_CARRIAGE
        MAP["PB"] = EfaHint.Code.FACE_MASK
        MAP["ER"] = EfaHint.Code.ACCESS_RAMP
        // TODO: G, RG, RO
    }

    override fun serialize(encoder: Encoder, value: EfaHint.Code?) {
        value?.let {
            MAP.entries.firstOrNull { (_, value) -> value == it }
                ?.key?.let(encoder::encodeString)
        } ?: encoder.encodeNull()
    }

    override fun deserialize(decoder: Decoder): EfaHint.Code? {
        val rawCode = decoder.decodeString()
        val mapped = MAP[rawCode]
        if (mapped == null) {
            println("Failed to map code $rawCode to EfaHInt Codes")
        }
        return mapped
    }
}