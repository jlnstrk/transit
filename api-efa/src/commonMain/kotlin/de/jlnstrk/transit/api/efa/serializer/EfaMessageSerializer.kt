package de.jlnstrk.transit.api.efa.serializer

import de.jlnstrk.transit.api.efa.response.EfaMessage
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonTransformingSerializer
import kotlinx.serialization.json.jsonObject

internal object EfaMessageSerializer : KSerializer<EfaMessage> {
    private val listSerializer = ListSerializer(Attribute.serializer())
    override val descriptor: SerialDescriptor = listSerializer.descriptor

    @Serializable
    @JsonClassDiscriminator("name")
    internal sealed class Attribute {
        @Serializable
        @SerialName("code")
        data class Code(val value: EfaMessage.Code? = null) : Attribute()

        @Serializable
        @SerialName("error")
        data class Error(val value: String? = null) : Attribute()

        @Serializable
        @SerialName("type")
        data class Type(val value: EfaMessage.Type? = null) : Attribute()

        @Serializable
        @SerialName("module")
        data class Module(val value: EfaMessage.Module) : Attribute()
    }

    override fun serialize(encoder: Encoder, value: EfaMessage) {
        val list = mutableListOf<Attribute>()
        list.add(Attribute.Code(value.code))
        value.error?.let { list.add(Attribute.Error(it)) }
        value.type?.let { list.add(Attribute.Type(it)) }
        list.add(Attribute.Module(value.module))
        listSerializer.serialize(encoder, list)
    }

    override fun deserialize(decoder: Decoder): EfaMessage {
        val list = listSerializer.deserialize(decoder)
        var code: EfaMessage.Code? = null
        var error: String? = null
        var type: EfaMessage.Type? = null
        var module: EfaMessage.Module? = null
        for (attribute in list) {
            when (attribute) {
                is Attribute.Code -> code = attribute.value
                is Attribute.Error -> error = attribute.value
                is Attribute.Type -> type = attribute.value
                is Attribute.Module -> module = attribute.value
            }
        }
        return EfaMessage(code, error, type, module!!)
    }

    object WithUnwrap : JsonTransformingSerializer<EfaMessage>(EfaMessageSerializer) {
        override fun transformDeserialize(element: JsonElement): JsonElement {
            return element.jsonObject.values.elementAt(0)
        }
    }
}