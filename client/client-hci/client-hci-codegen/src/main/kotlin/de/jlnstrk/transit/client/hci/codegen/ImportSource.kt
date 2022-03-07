package de.jlnstrk.transit.client.hci.codegen

import com.github.javaparser.JavaParser
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.EnumDeclaration
import com.squareup.kotlinpoet.TypeSpec
import de.jlnstrk.transit.client.hci.codegen.transform.toEnumRepresentation
import de.jlnstrk.transit.client.hci.codegen.transform.transformDataClass
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.extension
import kotlin.streams.asSequence

fun Path.buildImportSourceRepresentation(): Pair<String, List<TypeSpec>> {
    val javaParser = JavaParser()
    var hciVersion: String? = null
    val files = Files.walk(this)
        .asSequence()
        .filter { it.extension == "java" }
        .mapNotNull {
            val file = javaParser.parse(it)
            when (val classType = file.result.get().primaryType.get()) {
                is EnumDeclaration -> {
                    val enum = classType.toEnumRepresentation()
                    if (enum.name == "HCIVersion") {
                        hciVersion = enum.enumConstants.keys.maxOrNull()?.drop(1)?.replace("_", ".")
                    }
                    enum
                }
                is ClassOrInterfaceDeclaration -> classType.transformDataClass()
                else -> throw IllegalStateException()
            }
        }
        .map { it.toBuilder(name = it.name!!.replace("HCI", "Hci")).build() }
        .toList()
    return hciVersion!! to files
}