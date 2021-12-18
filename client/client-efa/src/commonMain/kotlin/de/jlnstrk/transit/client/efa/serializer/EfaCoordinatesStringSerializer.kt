package de.jlnstrk.transit.client.efa.serializer

import de.jlnstrk.transit.client.efa.model.EfaCoordinateSystem
import de.jlnstrk.transit.client.efa.model.EfaCoordinates
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal class EfaCoordinatesStringSerializer(
    private val system: EfaCoordinateSystem = EfaCoordinateSystem.WGS84_DECIMAL
) : KSerializer<EfaCoordinates> {
    override val descriptor: SerialDescriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: EfaCoordinates) {
        encoder.encodeString("${value.x},${value.y}")
    }

    override fun deserialize(decoder: Decoder): EfaCoordinates {
        val latLon = decoder.decodeString()
            .split(',')
        return EfaCoordinates(latLon[0].toDouble(), latLon[1].toDouble(), system)
    }
}