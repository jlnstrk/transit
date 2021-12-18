package de.jlnstrk.transit.client.hci.modelsync.transform

import com.squareup.kotlinpoet.*
import de.jlnstrk.transit.client.hci.modelsync.*

fun FileSpec.withSerializationAnnotations(hciVersion: String): FileSpec {
    val builder = toBuilder()
    builder.members.clear()

    (members[0] as TypeSpec).toBuilder()
        // Adds @HciModel("1.XX") to the class
        .addAnnotation(
            AnnotationSpec.builder(TYPE_NAME_HCI_MODEL)
                .addMember("%S", hciVersion ?: "?")
                .build()
        )
        // Adds @Serializable to the class
        .addAnnotation(TYPE_NAME_KOTLINX_SERIALIZABLE)

        .build()
        .let(builder::addType)

    // Check if this file requires any custom serializers
    val seen = mutableSetOf<TypeName>()
    val useSerializersMembers = mutableListOf<CodeBlock>()
    (members[0] as TypeSpec).propertySpecs.forEach { property ->
        if (property.type == TYPE_NAME_UTIL_LOCAL_DATE && TYPE_NAME_UTIL_LOCAL_DATE !in seen) {
            seen.add(TYPE_NAME_UTIL_LOCAL_DATE)
            useSerializersMembers.add(CodeBlock.of("%T::class", TYPE_NAME_UTIL_LOCAL_DATE_SERIALIZER))
        }
        if (property.type == TYPE_NAME_UTIL_LOCAL_TIME && TYPE_NAME_UTIL_LOCAL_TIME !in seen) {
            seen.add(TYPE_NAME_UTIL_LOCAL_TIME)
            useSerializersMembers.add(CodeBlock.of("%T::class", TYPE_NAME_UTIL_LOCAL_TIME_SERIALIZER))
        }
        if (property.type == TYPE_NAME_UTIL_ZONE_OFFSET && TYPE_NAME_UTIL_ZONE_OFFSET !in seen) {
            seen.add(TYPE_NAME_UTIL_ZONE_OFFSET)
            useSerializersMembers.add(CodeBlock.of("%T::class", TYPE_NAME_UTIL_ZONE_OFFSET_SERIALIZER))
        }
    }
    if (useSerializersMembers.isNotEmpty()) {
        val annotationSpec = AnnotationSpec.builder(TYPE_NAME_KOTLINX_USE_SERIALIZERS)
        useSerializersMembers.forEach(annotationSpec::addMember)
        builder.addAnnotation(annotationSpec.build())
    }

    return builder.build()
}