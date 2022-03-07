@file:OptIn(ExperimentalStdlibApi::class)

package de.jlnstrk.transit.client.hci.codegen

import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.typeNameOf
import de.jlnstrk.transit.client.hci.serializer.HciUnixTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalDateTime
import de.jlnstrk.transit.util.LocalTime

val StaticPropertyTypes: Map<String, TypeName> = buildMap {
    // date strings
    put("fpB", typeNameOf<LocalDate>())
    put("fpE", typeNameOf<LocalDate>())
    put("sD", typeNameOf<LocalDate>())

    // time strings
    put("sT", typeNameOf<LocalTime>())

    // date-time strings
    put("planrtTS", typeNameOf<LocalDateTime>())
    put("heartbeatTS", typeNameOf<LocalDateTime>())
}

val StaticPropertySerializers: Map<String, TypeName> = buildMap {
    put("planrtTS", typeNameOf<HciUnixTimeSerializer>())
    put("heartbeatTS", typeNameOf<HciUnixTimeSerializer>())
}