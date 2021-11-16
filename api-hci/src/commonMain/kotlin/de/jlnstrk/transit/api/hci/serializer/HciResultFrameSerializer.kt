package de.jlnstrk.transit.api.hci.serializer

import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.response.HciServiceError
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import de.jlnstrk.transit.api.hci.response.HciServiceResultFrame
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.serializer

internal object HciResultFrameSerializer : KSerializer<HciServiceResultFrame> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("HciResultFrame") {
        element("meth", HciServiceMethod.serializer().descriptor)
        element("err", HciServiceError.serializer().descriptor)
        element("errTxt", String.serializer().descriptor)
        element("errTxtOut", String.serializer().descriptor)
        element("id", String.serializer().descriptor)
        element("ctx", String.serializer().descriptor)
        element("statist", String.serializer().descriptor)
        element("res", HciServiceResult.serializer().descriptor)
    }

    override fun serialize(encoder: Encoder, value: HciServiceResultFrame) {
        throw UnsupportedOperationException()
    }

    @OptIn(InternalSerializationApi::class)
    override fun deserialize(decoder: Decoder): HciServiceResultFrame {
        val composite = decoder.beginStructure(descriptor)
        var meth: HciServiceMethod? = null
        var err: HciServiceError? = null
        var errTxt: String? = null
        var errTxtOut: String? = null
        var id: String? = null
        var ctx: String? = null
        var statist: String? = null
        var response: HciServiceResult? = null
        while (true) {
            when (val index = composite.decodeElementIndex(descriptor)) {
                0 -> meth =
                    composite.decodeSerializableElement(descriptor, index, HciServiceMethod.serializer())
                1 -> err = composite.decodeSerializableElement(descriptor, index, HciServiceError.serializer())
                2 -> errTxt = composite.decodeStringElement(descriptor, index)
                3 -> errTxtOut = composite.decodeStringElement(descriptor, index)
                4 -> id = composite.decodeStringElement(descriptor, index)
                5 -> ctx = composite.decodeStringElement(descriptor, index)
                6 -> statist = composite.decodeStringElement(descriptor, index)
                7 -> {
                    val tree = (composite as JsonDecoder).decodeJsonElement()
                    if (tree is JsonObject && tree.isNotEmpty()) {
                        response = (decoder as JsonDecoder).json.decodeFromJsonElement(
                            meth!!.responseType?.serializer() ?: throw UnsupportedOperationException(
                                "HCI service method \"$meth\" is not supported yet!"
                            ),
                            tree
                        )
                    }
                }
                CompositeDecoder.DECODE_DONE -> break
            }
        }
        composite.endStructure(descriptor)
        return HciServiceResultFrame(meth!!, err!!, errTxt, errTxtOut, id, ctx, statist, response)
    }
}