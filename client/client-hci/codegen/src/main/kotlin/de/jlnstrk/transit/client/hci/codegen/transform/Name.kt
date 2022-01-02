package de.jlnstrk.transit.client.hci.codegen.transform

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import de.jlnstrk.transit.client.hci.codegen.OUT_PACKAGE_NAME

fun TypeSpec.developFormat(): TypeSpec {
    return when {
        name!!.startsWith("HciServiceRequest_") -> transformConcreteHciServiceRequest()
        name!!.startsWith("HciServiceResult_") -> transformConcreteHciServiceResult()
        else -> toBuilder(name = name!!).build()
    }
}

private val PATTERN_METHOD = Regex("Hci([A-Za-z]+)Service(?:Request|Result)")
private val NON_METHODS = setOf("tariff", "service", "booking")

fun String.destinationPackageName(): String {
    PATTERN_METHOD.matchEntire(this)?.let { match ->
        val methodMatch = match.groupValues[1].lowercase()
        if (methodMatch !in NON_METHODS) {
            return "$OUT_PACKAGE_NAME.method.${methodMatch}"
        }
    }

    val woPrefix = substring(3)
    val humps = mutableListOf<String>()
    var lastUpper = 0
    for ((i, c) in woPrefix.withIndex()) {
        if (c.isUpperCase() && i > lastUpper) {
            humps.add(woPrefix.substring(lastUpper, i))
            lastUpper = i
        }
    }
    humps.add(woPrefix.substring(lastUpper))
    return ("$OUT_PACKAGE_NAME.model." + when (val first = humps.getOrNull(0).orEmpty().lowercase()) {
        "client",
        "connection",
        "eco",
        "fare",
        "geo",
        "gis",
        "gui",
        "him",
        "journey",
        "location",
        "message",
        "struct",
        "subscr",
        "tariff",
        "text",
        "user",
        "share",
        "rating",
        "feedback",
        "event",
        "chat",
        "booking" -> first
        "check" -> "checkin"
        "reconstruction" -> "recon"
        "train",
        "simple" -> "composition"
        else -> ""
    }).dropLastWhile { it == '.' }
}

fun TypeSpec.inPackage(): FileSpec {
    return FileSpec.builder(name!!.destinationPackageName(), name!!)
        .addType(this)
        .build()
}