package de.jlnstrk.transit.client.efa.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.*

internal class EfaListUnwrapSerializer<T>(
    elementSerializer: KSerializer<T>
) : JsonTransformingSerializer<List<T>>(ListSerializer(elementSerializer)) {

    override fun transformDeserialize(element: JsonElement): JsonElement {
        return element.jsonObject.values.elementAt(0)
            .let { it as? JsonArray ?: JsonArray(emptyList()) }
    }
}