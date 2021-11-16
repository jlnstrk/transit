package de.jlnstrk.transit.util.composite

import de.jlnstrk.transit.util.Provider

@DslMarker
internal annotation class CompositeDsl

public inline fun compose(init: CompositeProvider.() -> Unit): Provider {
    val composite = CompositeProvider()
    composite.init()
    return composite
}