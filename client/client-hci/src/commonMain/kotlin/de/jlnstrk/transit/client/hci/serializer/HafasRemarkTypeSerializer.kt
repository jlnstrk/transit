package de.jlnstrk.transit.client.hci.serializer

import de.jlnstrk.transit.client.hafas.HafasRemarkType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object HafasRemarkTypeSerializer : KSerializer<HafasRemarkType> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("HafasRemark.Type", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: HafasRemarkType) {
        throw UnsupportedOperationException()
    }

    override fun deserialize(decoder: Decoder): HafasRemarkType {
        val string = decoder.decodeString()
        // TODO: Make nullable (non-null to force crashes and discover more codes)
        return HafasRemarkType.UNKNOWN // HafasRemark.Type.MAP[string]!!
    }
}