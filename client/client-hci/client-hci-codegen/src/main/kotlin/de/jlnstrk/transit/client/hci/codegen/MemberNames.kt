package de.jlnstrk.transit.client.hci.codegen

import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.TypeName

object MemberNames {
    val kotlinxSerializationDescriptorsBuildClassSerialDescriptor = MemberName("kotlinx.serialization.descriptors", "buildClassSerialDescriptor")
    val kotlinxSerializationDescriptorsElement = MemberName("kotlinx.serialization.descriptors", "element")
    val kotlinxSerializationSerializer = MemberName("kotlinx.serialization", "serializer")
    val kotlinxSerializationBuiltinsSerializer = MemberName("kotlinx.serialization.builtins", "serializer")
    val kotlinxSerializationBuiltinsNullable = MemberName("kotlinx.serialization.builtins", "nullable")

    val resultType get() = MemberName("$OUT_PACKAGE_NAME.util", "resultType")
}

fun TypeName.staticSerializerAccessor(): MemberName = when {
    toString().startsWith("kotlin.") -> MemberNames.kotlinxSerializationBuiltinsSerializer
    else -> MemberNames.kotlinxSerializationSerializer
}