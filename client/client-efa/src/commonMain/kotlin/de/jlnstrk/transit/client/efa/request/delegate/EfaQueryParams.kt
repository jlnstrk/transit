package de.jlnstrk.transit.client.efa.request.delegate

import de.jlnstrk.transit.client.efa.request.convert.deserializeAsT
import de.jlnstrk.transit.client.efa.request.convert.serializeT
import de.jlnstrk.transit.util.*
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlin.reflect.KClass
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours as compHours
import kotlin.time.Duration.Companion.minutes

internal object EfaStringParam : EfaQueryParam<String>({ it }, { it })

internal object EfaIntParam : EfaQueryParam<Int>(kotlin.Int::toString, kotlin.String::toInt)

internal object EfaBooleanParam : EfaQueryParam<Boolean>({ if (it) "1" else "0" }, { it == "1" })

internal class EfaEnumParam<E : Enum<E>>(type: KClass<E>, key: String? = null) :
    EfaQueryParam<E>({ it.serializeT(type) }, { it.deserializeAsT(type) }, key) {
    companion object {
        inline operator fun <reified E : kotlin.Enum<E>> invoke(key: String? = null): EfaEnumParam<E> {
            return EfaEnumParam(E::class, key)
        }
    }
}

internal class EfaDateParam(format: DateFormat, key: String? = null) :
    EfaQueryParam<LocalDate>(format::formatDate, format::parseDate, key)

internal class EfaTimeParam(format: TimeFormat, key: String? = null) :
    EfaQueryParam<LocalTime>(format::formatTime, format::parseTime, key)

internal object EfaMinutesParam : EfaQueryParam<Duration>(
    serialize = { it.inWholeMinutes.toString() },
    deserialize = { it.toInt().minutes }
)

internal object EfaHoursParam : EfaQueryParam<Duration>(
    serialize = { it.inWholeHours.toString() },
    deserialize = { it.toInt().compHours },
)