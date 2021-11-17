package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.util.LazySortedSet
import kotlin.Comparator

public class LineSet(vararg elements: Line) : LazySortedSet<Line>(LineSet, *elements) {

    public companion object : Comparator<Line> {

        override fun compare(a: Line, b: Line): Int {
            var cmp = 0
            if (a::class == b::class) {
                cmp = (a as Comparable<Any>).compareTo(b)
                if (cmp == 0) {
                    cmp = a.name.orEmpty().compareTo(b.name.orEmpty())
                }
            }
            return cmp
        }
    }
}