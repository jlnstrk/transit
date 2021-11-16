package de.jlnstrk.transit.interop.hafas.extensions

public fun Int.log2(): Int {
    var pow = this
    var exp = 0
    while (pow > 1) {
        exp++
        pow = pow shr 1
    }
    return exp
}