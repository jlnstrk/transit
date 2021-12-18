package de.jlnstrk.transit.client.hci.modelsync.transform

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import de.jlnstrk.transit.client.hci.modelsync.OUT_PACKAGE_NAME

fun TypeSpec.developFormat(): TypeSpec {
    val newName = name!!.replace("HCI", "Hci")
    return when {
        newName.startsWith("HciServiceRequest") ->
            toBuilder(name = "Hci${newName.substringAfter("_")}Request")
                .build()
                .asServiceRequest()
        newName.startsWith("HciServiceResult") ->
            toBuilder(name = "Hci${newName.substringAfter("_")}Result")
                .build()
                .asServiceResult()
        else -> toBuilder(name = newName).build()
    }
}

private val PATTERN_METHOD = Regex("Hci([A-Za-z]+)(?:Request|Result)")

fun List<TypeSpec>.inPackages(): List<FileSpec> {
    fun TypeSpec.getPrefix(): String {
        var numUppercase = 0
        return name!!.substring(3).takeWhile {
            if (it.isUpperCase()) {
                ++numUppercase
            }
            numUppercase <= 1
        }
    }

    val groupPrefixes = groupBy(TypeSpec::getPrefix)
        .mapValues { (_, value) -> value.size }
        .filterValues { it >= 5 }
        .keys

    val modelPackage = "$OUT_PACKAGE_NAME.model"
    val servicePackage = "$OUT_PACKAGE_NAME.service"

    return map { typeSpec ->
        val packageName = when {
            typeSpec.name!!.endsWith("Request")
                    || typeSpec.name!!.endsWith("Result") -> {
                val match = PATTERN_METHOD.matchEntire(typeSpec.name!!)
                "$servicePackage.${match!!.groups[0]!!.value.toLowerCase()}"
            }
            else -> when (val prefix = typeSpec.getPrefix()) {
                in groupPrefixes -> {
                    var effectivePrefix = prefix.toLowerCase()
                    if (effectivePrefix in setOf("train", "simple")) {
                        effectivePrefix = "composition"
                    }

                    "$modelPackage.$effectivePrefix"
                }
                else -> modelPackage
            }
        }
        FileSpec.builder(packageName, typeSpec.name!!)
            .addType(typeSpec)
            .build()
    }
}