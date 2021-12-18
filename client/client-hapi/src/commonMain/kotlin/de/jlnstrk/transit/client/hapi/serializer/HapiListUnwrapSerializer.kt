package de.jlnstrk.transit.client.hapi.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.*

internal class HapiListUnwrapSerializer<T : Any>(
    delegate: KSerializer<T>
) : JsonTransformingSerializer<List<T>>(ListSerializer(delegate)) {
    override fun transformDeserialize(element: JsonElement): JsonElement {
        return element.jsonObject.values.first()
    }

    internal class DoubleNested<T : Any>(
        delegate: KSerializer<T>
    ) : JsonTransformingSerializer<List<T>>(ListSerializer(delegate)) {
        override fun transformDeserialize(element: JsonElement): JsonElement {
            return element.jsonArray.first().jsonObject.values.first()
                .let { if (it is JsonObject) JsonArray(listOf(it)) else it }
        }
    }
}