package de.jlnstrk.transit.api.hapi.serializer

import de.jlnstrk.transit.api.hapi.model.location.HapiCoordLocation
import de.jlnstrk.transit.api.hapi.model.location.HapiStopLocation
import de.jlnstrk.transit.api.hapi.model.location.HapiStopOrCoordLocation
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal class HapiStopOrCoordLocationSerializer : KSerializer<HapiStopOrCoordLocation> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("StopLocationOrCoordLocation") {
        element("StopLocation", HapiStopLocation.serializer().descriptor)
        element("CoordLocation", HapiCoordLocation.serializer().descriptor)
    }

    override fun serialize(encoder: Encoder, value: HapiStopOrCoordLocation) {
        throw UnsupportedOperationException()
    }

    override fun deserialize(decoder: Decoder): HapiStopOrCoordLocation {
        val composite = decoder.beginStructure(descriptor)
        var location: HapiStopOrCoordLocation? = null
        while (true) {
            location = when (val index = composite.decodeElementIndex(descriptor)) {
                0 -> composite.decodeSerializableElement(descriptor, index, HapiStopLocation.serializer())
                1 -> composite.decodeSerializableElement(descriptor, index, HapiCoordLocation.serializer())
                else -> break
            }
        }
        composite.endStructure(descriptor)
        return location!!
    }
}