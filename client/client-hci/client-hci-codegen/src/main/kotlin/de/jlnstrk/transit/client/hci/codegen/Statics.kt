@file:OptIn(ExperimentalStdlibApi::class)

package de.jlnstrk.transit.client.hci.codegen

import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.typeNameOf
import de.jlnstrk.transit.client.hci.serializer.HciUnixTimeSerializer
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlin.time.Duration

val StaticPropertyTypes: Map<String, TypeName> = buildMap {
    // date strings
    put("fpB", typeNameOf<LocalDate>())
    put("fpE", typeNameOf<LocalDate>())
    put("sD", typeNameOf<LocalDate>())

    // duration strings
    put("durS", typeNameOf<Duration>())
    put("durR", typeNameOf<Duration>())
    put("durST", typeNameOf<Duration>())
    put("durW2C", typeNameOf<Duration>())
    put("durW2D", typeNameOf<Duration>())

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