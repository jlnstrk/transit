package de.jlnstrk.transit.api.efa.serializer

import de.jlnstrk.transit.api.efa.serializer.generic.EfaOptionalListSerializer
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

internal class EfaListUnwrapSerializer<T>(
    elementSerializer: KSerializer<T>
) : JsonTransformingSerializer<List<T>>(ListSerializer(elementSerializer)) {

    override fun transformDeserialize(element: JsonElement): JsonElement {
        return element.jsonObject.values.elementAt(0)
            .let { it as? JsonArray ?: JsonArray(emptyList()) }
    }
}