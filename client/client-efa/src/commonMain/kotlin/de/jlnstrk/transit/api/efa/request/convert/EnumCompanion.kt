package de.jlnstrk.transit.api.efa.request.convert

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

public inline fun <reified E : Enum<E>> E.serialize(): String =
    Json.encodeToJsonElement(serializer(), this).jsonPrimitive.content

public inline fun <reified E : Enum<E>> String.deserializeAs(): E =
    Json.decodeFromJsonElement(serializer(), JsonPrimitive(this))

@OptIn(InternalSerializationApi::class)
public fun <E : Enum<E>> E.serializeT(type: KClass<E>): String =
    Json.encodeToJsonElement(type.serializer(), this).jsonPrimitive.content

@OptIn(InternalSerializationApi::class)
public fun <E : Enum<E>> String.deserializeAsT(type: KClass<E>): E =
    Json.decodeFromJsonElement(type.serializer(), JsonPrimitive(this))

internal interface EfaIntEnum  {
    val ordinal: Int
    val rawOrdinal: Int get() = ordinal
    val rawValue: String get() = rawOrdinal.toString()

    abstract class Companion<E>(protected val type: KClass<E>) where E : Enum<E>, E : EfaIntEnum {
        protected val map: Map<Int, E> =
            emptyMap() // type.java.enumConstants.associateBy { it.rawOrdinal }

        fun ofRawOrdinal(rawOrdinal: Int) = map[rawOrdinal]
    }

    interface Maskable : EfaIntEnum {
        abstract class Companion<E>(type: KClass<E>) : EfaIntEnum.Companion<E>(type)
                where E : Enum<E>, E : Maskable {
            fun ofRawMask(rawMask: Int): Set<E> {
                val set = mutableSetOf<E>()
                var power = 0
                var mask = rawMask
                while (mask != 0) {
                    if (mask and 1 == 1) {
                        map[power]?.let(set::add)
                    }
                    ++power
                    mask = mask ushr 1
                }
                return set
            }
        }
    }
}

internal fun <E : EfaIntEnum.Maskable> Set<E>.toRawMask(): Int {
    var mask = 0
    for (const in this) {
        mask += 1 shl const.rawOrdinal
    }
    return mask
}