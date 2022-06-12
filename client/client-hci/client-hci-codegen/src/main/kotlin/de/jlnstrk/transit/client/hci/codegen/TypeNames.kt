@file:OptIn(ExperimentalStdlibApi::class)

package de.jlnstrk.transit.client.hci.codegen

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.TypeName
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

var CONFIG: Map<String, String> = emptyMap()

var OUT_PACKAGE_NAME = ""
var DISABLED_SERVICE_METHODS = setOf("FeederBoard", "FetcherBoard")

object CustomSerializers {
    operator fun get(forType: TypeName): TypeName? = when (forType) {
        TypeNames.dateType -> TypeNames.dateSerializerType
        TypeNames.timeType -> TypeNames.timeSerializerType
        TypeNames.zoneOffsetType -> TypeNames.zoneOffsetSerializerType
        TypeNames.durationType -> TypeNames.durationSerializerType
        else -> null
    }
}

object TypeNames {
    val dateType: ClassName by SuppliedClassName
    val dateSerializerType: ClassName by SuppliedClassName
    val timeType: ClassName by SuppliedClassName
    val timeSerializerType: ClassName by SuppliedClassName
    val dateTimeType: ClassName by SuppliedClassName
    val dateTimeSerializerType: ClassName by SuppliedClassName
    val zoneOffsetType: ClassName by SuppliedClassName
    val zoneOffsetSerializerType: ClassName by SuppliedClassName
    val durationType: ClassName by SuppliedClassName
    val durationSerializerType: ClassName by SuppliedClassName

    val Deprecated = ClassName("kotlin", "Deprecated")
    val OptIn = ClassName("kotlin", "OptIn")
    val ExperimentalStdlibApi = ClassName("kotlin", "ExperimentalStdlibApi")
    val InternalSerializationApi = ClassName("kotlinx.serialization", "InternalSerializationApi")

    val UnsupportedOperationException = ClassName("kotlin", "UnsupportedOperationException")
    val IllegalArgumentException = ClassName("kotlin", "IllegalArgumentException")

    val Serializable = ClassName("kotlinx.serialization", "Serializable")
    val SerialName = ClassName("kotlinx.serialization", "SerialName")
    val UseSerializers = ClassName("kotlinx.serialization", "UseSerializers")

    val HciModel = ClassName("de.jlnstrk.transit.client.hafas", "HciModel")
    val HciCompat = ClassName("de.jlnstrk.transit.client.hci", "HciCompat")

    val HciServiceRequest get() = ClassName("$OUT_PACKAGE_NAME.model", "HciServiceRequest")
    val HciServiceResult get() = ClassName("$OUT_PACKAGE_NAME.model", "HciServiceResult")
    val HciServiceMethod get() = ClassName("$OUT_PACKAGE_NAME.model", "HciServiceMethod")

    val HciServiceRequestFrameSerializer get() = ClassName("$OUT_PACKAGE_NAME.serializer", "HciServiceRequestFrameSerializer")
    val HciServiceResultFrameSerializer get() = ClassName("$OUT_PACKAGE_NAME.serializer", "HciServiceResultFrameSerializer")

    fun HciServiceRequest(method: String) =
        ClassName("$OUT_PACKAGE_NAME.method.${method.lowercase()}", "Hci${method}ServiceRequest")

    fun HciServiceResult(method: String) =
        ClassName("$OUT_PACKAGE_NAME.method.${method.lowercase()}", "Hci${method}ServiceResult")
}

object SuppliedClassName : ReadOnlyProperty<Any, ClassName> {
    override fun getValue(thisRef: Any, property: KProperty<*>): ClassName {
        return CONFIG[property.name]?.let {
            val split = it.split('.')
            val packageNameComponents = split
                .takeWhile { it[0].isLowerCase() }
            ClassName(
                packageNameComponents.joinToString(separator = "."),
                split.takeLast(split.size - packageNameComponents.size)
            )
        } ?: ClassName("unknown", "UnknownType")
    }
}