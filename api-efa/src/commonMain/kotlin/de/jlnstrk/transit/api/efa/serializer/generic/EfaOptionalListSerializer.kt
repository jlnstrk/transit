package de.jlnstrk.transit.api.efa.serializer.generic

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

internal class EfaOptionalListSerializer<T>(
    itemSerializer: KSerializer<T>
) : JsonTransformingSerializer<List<T>>(ListSerializer(itemSerializer)) {
    override fun transformDeserialize(element: JsonElement): JsonElement {
        if (element is JsonNull) {
            return JsonArray(emptyList())
        }
        if (element is JsonObject) {
            if (element.jsonObject.size == 1) {
                return JsonArray(listOf(element.jsonObject.values.elementAt(0)))
            }
            return JsonArray(listOf(element))
        }
        return element
    }
}