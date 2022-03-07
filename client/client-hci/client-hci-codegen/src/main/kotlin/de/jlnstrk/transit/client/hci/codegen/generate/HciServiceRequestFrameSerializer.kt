@file:OptIn(ExperimentalStdlibApi::class)

package de.jlnstrk.transit.client.hci.codegen.generate

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import de.jlnstrk.transit.client.hci.codegen.MemberNames
import de.jlnstrk.transit.client.hci.codegen.TypeNames
import de.jlnstrk.transit.client.hci.codegen.staticSerializerAccessor
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

fun buildServiceRequestFrameSerializer(serviceRequest: FileSpec, destinationPackage: String): FileSpec {
    val type = serviceRequest.members[0] as TypeSpec
    val typeName = ClassName(serviceRequest.packageName, type.name!!)
    return FileSpec.builder(destinationPackage, "HciServiceRequestFrameSerializer").apply {
        addAnnotation(AnnotationSpec.builder(TypeNames.OptIn)
            .addMember("%T::class", TypeNames.InternalSerializationApi)
            .build())
        addAliasedImport(MemberNames.kotlinxSerializationBuiltinsSerializer, "builtinsSerializer")
        addType(TypeSpec.objectBuilder("HciServiceRequestFrameSerializer").apply {
            addModifiers(KModifier.INTERNAL)
            addSuperinterface(KSerializer::class.asTypeName().parameterizedBy(typeName))

            // override val descriptor: SerialDescriptor = HciServiceRequestFrame.serializer().descriptor
            addProperty(PropertySpec.builder("descriptor", typeNameOf<SerialDescriptor>(), KModifier.OVERRIDE).apply {
                initializer("%T.serializer().descriptor", typeName)
            }.build())

            addFunction(FunSpec.builder("serialize").apply {
                addModifiers(KModifier.OVERRIDE)
                addParameter("encoder", typeNameOf<Encoder>())
                addParameter("value", typeName)

                addStatement("val composite = encoder.beginStructure(descriptor)")

                for ((i, prop) in type.propertySpecs.withIndex()) {
                    when {
                        prop.name == "req" -> addStatement(
                            "composite.encodeSerializableElement(descriptor, $i, value.req::class.%M() as %T, value.req)",
                            MemberNames.kotlinxSerializationSerializer,
                            KSerializer::class.asTypeName().parameterizedBy(TypeNames.HciServiceRequest)
                        )
                        prop.type.isNullable -> addStatement(
                            "composite.encodeSerializableElement(descriptor, $i, %T.%M().%M, value.${prop.name})",
                            prop.type.copy(nullable = false),
                            prop.type.staticSerializerAccessor(),
                            MemberNames.kotlinxSerializationBuiltinsNullable
                        )
                        else -> addStatement(
                            "composite.encodeSerializableElement(descriptor, $i, %T.%M(), value.${prop.name})",
                            prop.type,
                            prop.type.staticSerializerAccessor(),
                        )
                    }
                }

                addStatement("composite.endStructure(descriptor)")
            }.build())

            addFunction(FunSpec.builder("deserialize").apply {
                addModifiers(KModifier.OVERRIDE)
                addParameter("decoder", typeNameOf<Decoder>())
                returns(typeName)
                addStatement("throw %T()", TypeNames.UnsupportedOperationException)
            }.build())

        }.build())
    }.build()
}