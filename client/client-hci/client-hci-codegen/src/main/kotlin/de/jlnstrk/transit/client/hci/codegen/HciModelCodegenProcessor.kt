package de.jlnstrk.transit.client.hci.codegen

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ksp.KotlinPoetKspPreview
import com.squareup.kotlinpoet.ksp.writeTo
import de.jlnstrk.transit.client.hci.codegen.generate.buildMethodToResultTypeMap
import de.jlnstrk.transit.client.hci.codegen.generate.buildRequestTypeToMethodMap
import de.jlnstrk.transit.client.hci.codegen.generate.buildServiceRequestFrameSerializer
import de.jlnstrk.transit.client.hci.codegen.generate.buildServiceResultFrameSerializer
import de.jlnstrk.transit.client.hci.codegen.transform.*
import java.nio.file.Paths

class HciModelCodegenProcessor(
    private val codeGenerator: CodeGenerator
) : SymbolProcessor {

    @OptIn(KotlinPoetKspPreview::class)
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val srcDir = "/Users/julianostarek/Desktop/hciver/1.45"

        val (hciVersion, importSource) = Paths.get(srcDir).buildImportSourceRepresentation()
        val compatSource = resolver.buildCompatPinningsRepresentation()

        val mergedSource = importSource.toMutableList()
        for (compatSpec in compatSource) {
            val index = importSource.indexOfFirst { it.name == compatSpec.name }
            if (index == -1) {
                mergedSource.add(compatSpec)
            } else {
                mergedSource[index] = mergedSource[index].toBuilder().apply {
                    compatSpec.propertySpecs.forEach { compatProp ->
                        val propIndex = propertySpecs.indexOfFirst { it.name == compatProp.name }
                        if (propIndex == -1) {
                            propertySpecs.add(compatProp)
                        } else {
                            propertySpecs[propIndex] = compatProp
                        }
                    }
                    compatSpec.primaryConstructor?.let { compatPrimary ->
                        val importPrimary =
                            mergedSource[index].primaryConstructor?.toBuilder() ?: FunSpec.constructorBuilder()
                        compatPrimary.parameters.forEach { compatParam ->
                            val paramIndex = importPrimary.parameters.indexOfFirst { it.name == compatParam.name }
                            if (paramIndex == -1) {
                                importPrimary.addParameter(compatParam)
                            } else {
                                importPrimary.parameters[paramIndex] = compatParam
                            }
                        }
                        primaryConstructor(importPrimary.build())
                    }
                }.build()
            }
        }

        val generated = mergedSource.map(TypeSpec::developFormat)
            .map(TypeSpec::inPackage)
            .map { it.withSerializationAnnotations(hciVersion) }
            .toMutableList()

        var hciServiceRequestFrameSpec: FileSpec? = null
        var hciServiceResultFrameSpec: FileSpec? = null
        var hciServiceMethodFrameSpec: FileSpec? = null

        for ((i, fileSpec) in generated.withIndex()) {
            for (member in fileSpec.members) {
                if (member is TypeSpec) {
                    when (member.name) {
                        "HciRequest" -> generated[i] = fileSpec.toBuilder().apply {
                            members[0] = (fileSpec.members[0] as TypeSpec).transformHciRequest()
                        }.build()
                        "HciResult" -> generated[i] = fileSpec.toBuilder().apply {
                            members[0] = (fileSpec.members[0] as TypeSpec).transformHciResult()
                        }.build()
                        "HciServiceRequest" -> generated[i] = fileSpec.toBuilder().apply {
                            members[0] = (fileSpec.members[0] as TypeSpec).transformAbstractHciServiceRequest()
                        }.build()
                        "HciServiceResult" -> generated[i] = fileSpec.toBuilder().apply {
                            members[0] = (fileSpec.members[0] as TypeSpec).transformAbstractHciServiceResult()
                        }.build()
                        "HciServiceRequestFrame" -> hciServiceRequestFrameSpec = fileSpec
                        "HciServiceResultFrame" -> hciServiceResultFrameSpec = fileSpec
                        "HciServiceMethod" -> hciServiceMethodFrameSpec = fileSpec
                    }
                }
            }
        }

        // Get a hold of the HciServiceResultFrame type and generate a custom deserializer for it
        hciServiceResultFrameSpec?.let { serviceResultSpec ->
            hciServiceMethodFrameSpec?.let { serviceMethodSpec ->
                buildServiceResultFrameSerializer(serviceResultSpec, serviceMethodSpec, "$OUT_PACKAGE_NAME.serializer")
                    .let(generated::add)
            }
        }

        // Get a hold of the HciServiceRequestFrame type and generate a custom serializer for it
        hciServiceRequestFrameSpec?.let {
            buildServiceRequestFrameSerializer(it, "$OUT_PACKAGE_NAME.serializer")
                .let(generated::add)
        }

        // Get a hold of HciServiceMethod and generate mappings to/from it
        hciServiceMethodFrameSpec?.let {
            buildMethodToResultTypeMap(it, "$OUT_PACKAGE_NAME.util")
                .let(generated::add)
            buildRequestTypeToMethodMap(it, "$OUT_PACKAGE_NAME.util")
                .let(generated::add)
        }

        // Write it all to build/generated/ksp.
        // In the 'transit' project, module ':client:client-hci:model' has a gradle task
        // to grab it from there and put it into the srcDir
        // ':client:client-hci' itself has an API dependency on it to have a merged API surface
        // amended by utils such as serializers for common time types, a Ktor entrypoint etc.
        generated.forEach {
            try {
                it.writeTo(codeGenerator, Dependencies(false))
            } catch (e: FileAlreadyExistsException) {
                e.printStackTrace()
            }
        }

        return emptyList()
    }

    companion object {
        private val SUPPORTED_ANNOTATION_TYPES = mutableSetOf("de.jlnstrk.transit.client.hafas.HciModel")
    }
}