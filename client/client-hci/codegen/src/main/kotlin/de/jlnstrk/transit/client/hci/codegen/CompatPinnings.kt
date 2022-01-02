@file:OptIn(KotlinPoetKspPreview::class)

package de.jlnstrk.transit.client.hci.codegen

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFile
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ksp.KotlinPoetKspPreview
import com.squareup.kotlinpoet.ksp.toTypeName
import de.jlnstrk.transit.client.hci.codegen.transform.destinationPackageName

val SEARCH_PACKAGES = setOf("compat")

fun Resolver.buildCompatPinningsRepresentation(): List<TypeSpec> {
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
                    val assumedType = if (propertyDecl.type.resolve().isError) {
                        ClassName(
                            propertyDecl.type.toString().destinationPackageName(),
                            propertyDecl.type.toString()
                        )
                    } else propertyDecl.type.toTypeName()
                    val paramSpec =
                        ParameterSpec.builder(propertyDecl.simpleName.asString(), assumedType)
                    for (annotation in propertyDecl.annotations) {
                        when (annotation.shortName.getShortName()) {
                            "DefaultExpr" -> annotation.arguments
                                .firstOrNull()
                                ?.value
                                ?.let {
                                    (it as String).let {
                                        paramSpec.defaultValue(it)
                                    }
                                }
                            "HciCompat" -> {
                                val hciCompatBuilder = AnnotationSpec.builder(TypeNames.HciCompat)

                                val argValues = mutableMapOf<String, Any>()

                                annotation.arguments.forEach { arg ->
                                    (arg.value as? String).orEmpty().ifEmpty { null }?.let { value ->
                                        hciCompatBuilder.addMember("${arg.name!!.getShortName()} = %S", value)
                                        argValues[arg.name!!.getShortName()] = arg.value!!
                                    }
                                }

                                if (argValues.isNotEmpty()) {
                                    AnnotationSpec.builder(TypeNames.Deprecated)
                                        .addMember(
                                            "%S", when {
                                                argValues.containsKey("removed") -> "Removed with HCI version ${argValues["removed"]}"
                                                else -> "Removed after HCI version ${argValues["removedAfter"]}, but before version ${argValues["removedBefore"]}"
                                            }
                                        )
                                        .build()
                                        .let(paramSpec::addAnnotation)
                                }

                                paramSpec.addAnnotation(hciCompatBuilder.build())
                            }
                        }
                    }
                    propertyDecl.annotations.firstOrNull { it.shortName.getShortName() == "DefaultExpr" }

                    val propertySpec =
                        PropertySpec.builder(propertyDecl.simpleName.asString(), assumedType)
                            .mutable(false)
                            .initializer(propertyDecl.simpleName.asString())
                    primaryConstructor.addParameter(paramSpec.build())
                    typeSpec.addProperty(propertySpec.build())
                }
            typeSpec.primaryConstructor(primaryConstructor.build())
            typeSpec.build()
        }.toList()
}