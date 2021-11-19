package de.jlnstrk.transit.api.hapi.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonTransformingSerializer

internal class HapiOptionalListSerializer<T : Any>(
    delegate: KSerializer<T>
) : JsonTransformingSerializer<List<T>>(ListSerializer(delegate)) {
    override fun transformDeserialize(element: JsonElement): JsonElement {
        return if (element is JsonArray) element else JsonArray(listOf(element))
    }
}