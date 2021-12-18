package de.jlnstrk.transit.client.hci.modelsync

import com.squareup.kotlinpoet.ClassName

const val BASE_PACKAGE_NAME = "de.jlnstrk.transit"
const val OUT_PACKAGE_NAME = "$BASE_PACKAGE_NAME.client.hci"

val TYPE_NAME_KOTLINX_SERIALIZABLE = ClassName("kotlinx.serialization", "Serializable")
val TYPE_NAME_KOTLINX_SERIAL_NAME = ClassName("kotlinx.serialization", "SerialName")
val TYPE_NAME_KOTLINX_USE_SERIALIZERS = ClassName("kotlinx.serialization", "UseSerializers")

val TYPE_NAME_UTIL_LOCAL_DATE = ClassName("$BASE_PACKAGE_NAME.util", "LocalDate")
val TYPE_NAME_UTIL_LOCAL_DATE_SERIALIZER = ClassName("$OUT_PACKAGE_NAME.serializer", "HciLocalDateSerializer")
val TYPE_NAME_UTIL_LOCAL_TIME = ClassName("$BASE_PACKAGE_NAME.util", "LocalTime")
val TYPE_NAME_UTIL_LOCAL_TIME_SERIALIZER = ClassName("$OUT_PACKAGE_NAME.serializer", "HciLocalTimeSerializer")
val TYPE_NAME_UTIL_ZONE_OFFSET = ClassName("$BASE_PACKAGE_NAME.util", "ZoneOffset")
val TYPE_NAME_UTIL_ZONE_OFFSET_SERIALIZER = ClassName("$OUT_PACKAGE_NAME.serializer", "HciZoneOffsetSerializer")

val TYPE_NAME_HCI_MODEL = ClassName("de.jlnstrk.transit.client.hafas", "HciModel")
val TYPE_NAME_HCI_SERVICE_REQUEST = ClassName(OUT_PACKAGE_NAME, "HciServiceRequest")
val TYPE_NAME_HCI_SERVICE_RESULT = ClassName(OUT_PACKAGE_NAME, "HciServiceResult")
val TYPE_NAME_HCI_SERVICE_METHOD = ClassName(OUT_PACKAGE_NAME, "HciServiceMethod")