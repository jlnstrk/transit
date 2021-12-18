@file:OptIn(KotlinPoetKspPreview::class)

package de.jlnstrk.transit.client.hci.modelsync

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFile
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ksp.KotlinPoetKspPreview
import com.squareup.kotlinpoet.ksp.toTypeName

val SEARCH_PACKAGES = setOf("model", "services")

fun Resolver.buildExistingSourceRepresentation(): List<TypeSpec> {
    return getAllFiles()
        .filter {
            val segments = it.filePath.split("/")
            (segments.size >= 2 && segments[segments.size - 2] in SEARCH_PACKAGES)
                    || segments[segments.size - 1] in SEARCH_PACKAGES
        }
        .flatMap(KSFile::declarations)
        .filterIsInstance<KSClassDeclaration>()
        .map { classDecl ->
            val typeSpec = TypeSpec.classBuilder(classDecl.simpleName.getShortName())
            typeSpec.addModifiers(KModifier.DATA)
            val primaryConstructor = FunSpec.constructorBuilder()
            classDecl.declarations.filterIsInstance<KSPropertyDeclaration>()
                .forEach { propertyDecl ->
                    try {
                        val paramSpec =
                            ParameterSpec.builder(propertyDecl.simpleName.asString(), propertyDecl.type.toTypeName())
                        val propertySpec =
                            PropertySpec.builder(propertyDecl.simpleName.asString(), propertyDecl.type.toTypeName())
                                .mutable(false)
                                .initializer(propertyDecl.simpleName.asString())
                        primaryConstructor.addParameter(paramSpec.build())
                        typeSpec.addProperty(propertySpec.build())
                    } catch (e: Exception) {
                        System.err.println(e.stackTraceToString())
                    }
                }
            typeSpec.primaryConstructor(primaryConstructor.build())
            typeSpec.build()
        }.toList()
}