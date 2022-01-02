@file:OptIn(ExperimentalStdlibApi::class)

package de.jlnstrk.transit.client.hci.codegen.generate

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import de.jlnstrk.transit.client.hci.codegen.MemberNames
import de.jlnstrk.transit.client.hci.codegen.TypeNames
import de.jlnstrk.transit.client.hci.codegen.staticSerializerAccessor
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject

fun buildServiceResultFrameSerializer(
    serviceResult: FileSpec,
    serviceMethod: FileSpec,
    destinationPackage: String,
): FileSpec {
    val type = serviceResult.members[0] as TypeSpec
    val typeName = ClassName(serviceResult.packageName, type.name!!)

    val methodType = serviceMethod.members[0] as TypeSpec
    val methodTypeName = ClassName(serviceMethod.packageName, methodType.name!!)

    return FileSpec.builder(destinationPackage, "HciServiceResultFrameSerializer").apply {
        addAnnotation(
            AnnotationSpec.builder(TypeNames.OptIn)
                .addMember("%T::class", TypeNames.ExperimentalStdlibApi)
                .addMember("%T::class", TypeNames.InternalSerializationApi)
                .build()
        )
        addAliasedImport(MemberNames.kotlinxSerializationBuiltinsSerializer, "builtinsSerializer")
        addType(TypeSpec.objectBuilder("HciServiceResultFrameSerializer").apply {
            addModifiers(KModifier.INTERNAL)
            addSuperinterface(KSerializer::class.asTypeName().parameterizedBy(typeName))

            addProperty(
                PropertySpec.builder("descriptor", typeNameOf<SerialDescriptor>(), KModifier.OVERRIDE)
                    .initializer(
                        CodeBlock.builder().apply {
                            beginControlFlow(
                                "%M(%S)",
                                MemberNames.kotlinxSerializationDescriptorsBuildClassSerialDescriptor,
                                typeName.simpleName
                            )
                            for (prop in type.propertySpecs) {
                                addStatement(
                                    "%M(%S, %T.%M().descriptor)",
                                    MemberNames.kotlinxSerializationDescriptorsElement,
                                    prop.name,
                                    prop.type.copy(nullable = false),
                                    prop.type.staticSerializerAccessor()
                                )
                            }
                            endControlFlow()
                        }.build()
                    )
                    .build()
            )

            addFunction(FunSpec.builder("serialize").apply {
                addModifiers(KModifier.OVERRIDE)
                addParameter("encoder", typeNameOf<Encoder>())
                addParameter("value", typeName)
                addStatement("throw %T()", TypeNames.UnsupportedOperationException)
            }.build())

            addFunction(FunSpec.builder("deserialize").apply {
                addModifiers(KModifier.OVERRIDE)
                returns(typeName)
                addParameter("decoder", typeNameOf<Decoder>())
                addStatement("val composite = decoder.beginStructure(descriptor)")
                for (prop in type.propertySpecs) {
                    addStatement("var ${prop.name}: %T = null", prop.type.copy(nullable = true))
                }
                beginControlFlow("while (true)")
                beginControlFlow("when (val index = composite.decodeElementIndex(descriptor))")
                for ((i, prop) in type.propertySpecs.withIndex()) {
                    when {
                        prop.name == "res" -> {
                            beginControlFlow("$i ->")
                            addStatement("val tree = (composite as %T).decodeJsonElement()", typeNameOf<JsonDecoder>())
                            beginControlFlow("if (tree is %T && tree.isNotEmpty())", typeNameOf<JsonObject>())
                            addStatement(
                                "res = (composite as %T).json.decodeFromJsonElement(meth!!.%M.%M(), tree)",
                                typeNameOf<JsonDecoder>(),
                                MemberNames.resultType,
                                prop.type.staticSerializerAccessor()
                            )
                            endControlFlow()
                            endControlFlow()
                        }
                        prop.type.isNullable -> addStatement(
                            "$i -> ${prop.name} = composite.decodeSerializableElement(descriptor, index, %T.%M().%M)",
                            prop.type.copy(nullable = false),
                            prop.type.staticSerializerAccessor(),
                            MemberNames.kotlinxSerializationBuiltinsNullable
                        )
                        else -> addStatement(
                            "$i -> ${prop.name} = composite.decodeSerializableElement(descriptor, index, %T.%M())",
                            prop.type.copy(nullable = false),
                            prop.type.staticSerializerAccessor()
                        )
                    }
                }
                addStatement("%T.DECODE_DONE -> break", typeNameOf<CompositeDecoder>())
                endControlFlow()
                endControlFlow()
                addStatement("composite.endStructure(descriptor)")
                addStatement(
                    "return %T(${type.propertySpecs.joinToString { "${it.name} = ${it.name}" + if (it.type.isNullable) "" else "!!" }})",
                    typeName
                )
            }.build())
        }.build())
    }.build()
}