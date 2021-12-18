package de.jlnstrk.transit.client.hci.modelsync

import com.github.javaparser.JavaParser
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ksp.KotlinPoetKspPreview
import com.squareup.kotlinpoet.ksp.writeTo
import de.jlnstrk.transit.client.hci.modelsync.transform.developFormat
import de.jlnstrk.transit.client.hci.modelsync.transform.inPackages
import de.jlnstrk.transit.client.hci.modelsync.transform.withSerializationAnnotations
import java.nio.file.Paths

class HciModelSymbolProcessor(
    private val codeGenerator: CodeGenerator
) : SymbolProcessor {

    @OptIn(KotlinPoetKspPreview::class)
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val srcDir = "/Users/julian/Downloads/hci139/src/main/java/de/hafas/hci/model"

        val (hciVersion, importSource) = Paths.get(srcDir).buildImportSourceRepresentation()
        val existingSource = resolver.buildExistingSourceRepresentation()

        importSource.map(TypeSpec::developFormat)
            .inPackages()
            .map { it.withSerializationAnnotations(hciVersion) }
            .forEach {
                it.writeTo(codeGenerator, Dependencies(false))
            }

        return emptyList()
    }

    companion object {
        private val SUPPORTED_ANNOTATION_TYPES = mutableSetOf("de.jlnstrk.transit.client.hafas.HciModel")
    }
}