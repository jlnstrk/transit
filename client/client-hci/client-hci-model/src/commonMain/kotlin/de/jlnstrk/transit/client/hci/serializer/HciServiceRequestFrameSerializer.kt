@file:OptIn(InternalSerializationApi::class)

package de.jlnstrk.transit.client.hci.serializer

import de.jlnstrk.transit.client.hci.model.HciRequestConfig
import de.jlnstrk.transit.client.hci.model.HciServiceMethod
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.HciServiceRequestFrame
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.UnsupportedOperationException
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.serializer
import kotlinx.serialization.builtins.serializer as builtinsSerializer

internal object HciServiceRequestFrameSerializer : KSerializer<HciServiceRequestFrame> {
  public override val descriptor: SerialDescriptor = HciServiceRequestFrame.serializer().descriptor

  public override fun serialize(encoder: Encoder, `value`: HciServiceRequestFrame): Unit {
    val composite = encoder.beginStructure(descriptor)
    composite.encodeSerializableElement(descriptor, 0, HciRequestConfig.serializer().nullable,
        value.cfg)
    composite.encodeSerializableElement(descriptor, 1, String.builtinsSerializer().nullable,
        value.ctx)
    composite.encodeSerializableElement(descriptor, 2, String.builtinsSerializer().nullable,
        value.id)
    composite.encodeSerializableElement(descriptor, 3, HciServiceMethod.serializer(), value.meth)
    composite.encodeSerializableElement(descriptor, 4, value.req::class.serializer() as
        KSerializer<HciServiceRequest>, value.req)
    composite.endStructure(descriptor)
  }

  public override fun deserialize(decoder: Decoder): HciServiceRequestFrame = throw
      UnsupportedOperationException()
}
