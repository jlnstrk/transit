package de.jlnstrk.transit.client.efa.request.delegate

import com.soywiz.klock.*
import de.jlnstrk.transit.client.efa.request.convert.deserializeAsT
import de.jlnstrk.transit.client.efa.request.convert.serializeT
import de.jlnstrk.transit.util.DateFormatter
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlin.reflect.KClass

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

internal class EfaDateParam(format: DateFormatter, key: String? = null) :
    EfaQueryParam<LocalDate>(format::format, format::parseDate, key)

internal class EfaTimeParam(format: TimeFormat, key: String? = null) :
    EfaQueryParam<LocalTime>(format::format, format::parseTime, key)

internal object EfaMinutesParam : EfaQueryParam<Duration>(
    serialize = { it.minutes.toLong().toString() },
    deserialize = { it.toLong().minutes }
)

internal object EfaHoursParam : EfaQueryParam<Duration>(
    serialize = { it.hours.toInt().toString() },
    deserialize = { it.toInt().hours },
)