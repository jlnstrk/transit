package de.jlnstrk.transit.util.model

import de.jlnstrk.transit.util.LazySortedSet

public class ProductSet(vararg elements: ProductClass) :
    LazySortedSet<ProductClass>(ProductSet, *elements) {

    public companion object : Comparator<ProductClass> {
        override fun compare(a: ProductClass, b: ProductClass): Int {
            return when {
                a is Means && b is Means -> a.compareTo(b)
                a is Means && b !is Means -> -1
                a !is Means && b is Means -> 1
                a is Enum<*> && b is Enum<*> -> {
                    if (a::class == b::class)
                        return a.ordinal.compareTo(b.ordinal)
                    throw IllegalStateException("Must not use multiple custom product types!")
                }
                else -> throw IllegalStateException()
            }
        }
    }
}