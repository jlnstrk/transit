package de.jlnstrk.transit.client.hci.modelsync.transform

import com.github.javaparser.ast.body.EnumDeclaration
import com.github.javaparser.ast.expr.StringLiteralExpr
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.TypeSpec
import de.jlnstrk.transit.client.hci.modelsync.TYPE_NAME_KOTLINX_SERIAL_NAME

fun EnumDeclaration.toEnumRepresentation(): TypeSpec {
    if (!isEnumDeclaration)
        throw IllegalArgumentException()

    val enumSpec = TypeSpec.enumBuilder(nameAsString)
    entries.forEach {  enumDecl ->
            val constantSpec = TypeSpec.anonymousClassBuilder()

            val literalArg = (enumDecl.arguments[0] as? StringLiteralExpr)?.asString()
            if (literalArg != null && enumDecl.nameAsString != literalArg) {
                constantSpec.addAnnotation(AnnotationSpec.builder(TYPE_NAME_KOTLINX_SERIAL_NAME)
                    .addMember("%S", literalArg)
                    .build())
            }

            enumSpec.addEnumConstant(enumDecl.nameAsString, constantSpec.build())
        }
    return enumSpec.build()
}