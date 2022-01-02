@file:OptIn(
  ExperimentalStdlibApi::class,
  InternalSerializationApi::class
)

package de.jlnstrk.transit.client.hci.serializer

import de.jlnstrk.transit.client.hci.model.HciServiceError
import de.jlnstrk.transit.client.hci.model.HciServiceMethod
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.HciServiceResultFrame
import de.jlnstrk.transit.client.hci.util.resultType
import kotlin.ExperimentalStdlibApi
import kotlin.OptIn
import kotlin.String
import kotlin.UnsupportedOperationException
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.serializer
import kotlinx.serialization.builtins.serializer as builtinsSerializer

internal object HciServiceResultFrameSerializer : KSerializer<HciServiceResultFrame> {
  public override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("HciServiceResultFrame") {
    element("ctx", String.builtinsSerializer().descriptor)
    element("err", HciServiceError.serializer().descriptor)
    element("errTxt", String.builtinsSerializer().descriptor)
    element("errTxtOut", String.builtinsSerializer().descriptor)
    element("id", String.builtinsSerializer().descriptor)
    element("meth", HciServiceMethod.serializer().descriptor)
    element("res", HciServiceResult.serializer().descriptor)
    element("statist", String.builtinsSerializer().descriptor)
  }


  public override fun serialize(encoder: Encoder, `value`: HciServiceResultFrame) = throw
      UnsupportedOperationException()

  public override fun deserialize(decoder: Decoder): HciServiceResultFrame {
    val composite = decoder.beginStructure(descriptor)
    var ctx: String? = null
    var err: HciServiceError? = null
    var errTxt: String? = null
    var errTxtOut: String? = null
    var id: String? = null
    var meth: HciServiceMethod? = null
    var res: HciServiceResult? = null
    var statist: String? = null
    while (true) {
      when (val index = composite.decodeElementIndex(descriptor)) {
        0 -> ctx = composite.decodeSerializableElement(descriptor, index,
            String.builtinsSerializer().nullable)
        1 -> err = composite.decodeSerializableElement(descriptor, index,
            HciServiceError.serializer())
        2 -> errTxt = composite.decodeSerializableElement(descriptor, index,
            String.builtinsSerializer().nullable)
        3 -> errTxtOut = composite.decodeSerializableElement(descriptor, index,
            String.builtinsSerializer().nullable)
        4 -> id = composite.decodeSerializableElement(descriptor, index,
            String.builtinsSerializer().nullable)
        5 -> meth = composite.decodeSerializableElement(descriptor, index,
            HciServiceMethod.serializer().nullable)
        6 -> {
          val tree = (composite as JsonDecoder).decodeJsonElement()
          if (tree is JsonObject && tree.isNotEmpty()) {
            res = (composite as
                JsonDecoder).json.decodeFromJsonElement(meth!!.resultType.serializer(), tree)
          }
        }
        7 -> statist = composite.decodeSerializableElement(descriptor, index,
            String.builtinsSerializer().nullable)
        CompositeDecoder.DECODE_DONE -> break
      }
    }
    composite.endStructure(descriptor)
    return HciServiceResultFrame(ctx = ctx, err = err!!, errTxt = errTxt, errTxtOut = errTxtOut, id
        = id, meth = meth, res = res, statist = statist)
  }
}
