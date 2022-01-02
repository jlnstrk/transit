@file:OptIn(ExperimentalStdlibApi::class)

package de.jlnstrk.transit.client.hci.codegen.transform

import com.squareup.kotlinpoet.*
import de.jlnstrk.transit.client.hci.codegen.*
import kotlinx.serialization.Serializable

fun FileSpec.withSerializationAnnotations(hciVersion: String): FileSpec {
    return toBuilder().apply {
        members[0] = (members[0] as TypeSpec).toBuilder().apply {
            // Adds @HciModel("1.XX") to the class
            addAnnotation(
                AnnotationSpec.builder(TypeNames.HciModel)
                    .addMember("%S", hciVersion)
                    .build()
            )
            // Adds @Serializable to the class
            addAnnotation(TypeNames.Serializable)
        }.build()

        // Check if this file requires any top-level custom serializers
        val seen = mutableSetOf<TypeName>()
        val useSerializersMembers = mutableListOf<CodeBlock>()
        (members[0] as TypeSpec).propertySpecs.forEach { property ->
            if (property.annotations.none { it.typeName == typeNameOf<Serializable>() }) {
                CustomSerializers[property.type]?.let { serializerType ->
                    if (seen.add(serializerType)) {
                        useSerializersMembers.add(CodeBlock.of("%T::class", serializerType))
                    }
                }
            }
        }
        if (useSerializersMembers.isNotEmpty()) {
            addAnnotation(AnnotationSpec.builder(TypeNames.UseSerializers).apply {
                useSerializersMembers.forEach { addMember(it) }
            }.build())
        }
    }.build()
}

fun TypeSpec.extractSerialName(): String {
    return annotationSpecs.first().members.first()
        .toString()
        .drop(1)
        .dropLast(1)
}