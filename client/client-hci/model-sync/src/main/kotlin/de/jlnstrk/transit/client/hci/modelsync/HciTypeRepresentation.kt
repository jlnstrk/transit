package de.jlnstrk.transit.client.hci.modelsync

import com.squareup.kotlinpoet.TypeSpec

data class HciTypeRepresentation(
    val typeSpec: TypeSpec,
    val kind: Kind,
) {
    enum class Kind {
        SERVICE_REQUEST,
        SERVICE_RESULT,
        ENUM,
        PLAIN
    }
}