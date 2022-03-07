package de.jlnstrk.transit.client.hci.codegen

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class HciModelCodegenProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        environment.options[OPTION_OUT_PACKAGE_NAME]?.let {
            OUT_PACKAGE_NAME = it
        }
        CONFIG = environment.options
        return HciModelCodegenProcessor(environment.codeGenerator)
    }

    companion object {
        const val OPTION_OUT_PACKAGE_NAME = "outPackageName"
    }
}