package de.jlnstrk.transit.util.extensions

import de.jlnstrk.transit.util.model.Line
import de.jlnstrk.transit.util.model.LineSet
import de.jlnstrk.transit.util.model.ProductClass
import de.jlnstrk.transit.util.model.ProductSet

public inline fun <F, T> Array<T?>.computeIfAbsent(source: List<F>, index: Int, compute: (F) -> T): T {
    if (this[index] == null) {
        this[index] = compute(source[index])
    }
    return this[index]!!
}

public inline fun Collection<ProductClass>.toProductSet(): ProductSet = toCollection(ProductSet())

public inline fun Collection<Line>.toLineSet(): LineSet = toCollection(LineSet())