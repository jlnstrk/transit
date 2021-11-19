package de.jlnstrk.transit.api.hci.serializer

import de.jlnstrk.transit.api.hafas.HafasRemarkCode
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object HafasRemarkCodeSerializer : KSerializer<HafasRemarkCode?> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("HafasRemark.Code", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: HafasRemarkCode?) {
        throw UnsupportedOperationException()
    }

    override fun deserialize(decoder: Decoder): HafasRemarkCode? {
        val string = decoder.decodeString()
        // TODO: Make nullable (non-null to force crashes and discover more codes)
        val code: HafasRemarkCode? = null // val code = HafasRemark.Code.MAP[string]
        if (code == null) {
            println("Could not map code $string to HafasRemark Codes")
        }
        return code
    }
}