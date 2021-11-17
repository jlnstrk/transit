package de.jlnstrk.transit.common.extensions

import de.jlnstrk.transit.common.model.Line
import de.jlnstrk.transit.common.model.LineSet
import de.jlnstrk.transit.common.model.ProductClass
import de.jlnstrk.transit.common.model.ProductSet

public inline fun <F, T> Array<T?>.computeIfAbsent(source: List<F>, index: Int, compute: (F) -> T): T {
    if (this[index] == null) {
        this[index] = compute(source[index])
    }
    return this[index]!!
}

public inline fun Collection<ProductClass>.toProductSet(): ProductSet = toCollection(ProductSet())

public inline fun Collection<Line>.toLineSet(): LineSet = toCollection(LineSet())