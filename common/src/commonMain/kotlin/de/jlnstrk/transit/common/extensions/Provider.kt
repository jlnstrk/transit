package de.jlnstrk.transit.common.extensions

import de.jlnstrk.transit.common.CompositeProvider
import de.jlnstrk.transit.common.Provider
import de.jlnstrk.transit.common.Service

/** @see [CompositeProvider.use] */
public inline fun <reified S : Service> CompositeProvider.use(from: Provider) {
    use(S::class, from)
}

/** @see [CompositeProvider.Delegate.use] */
public inline fun <reified S : Service> CompositeProvider.Delegate.use() {
    use(S::class)
}

/** @see [Provider.require] */
public inline fun <reified C : Service> Provider.require(): C = require(C::class)

/** @see [Provider.optional] */
public inline fun <reified S : Service> Provider.optional(): S? = optional(S::class)

/** @see [Provider.offers] */
public inline fun <reified S : Service> Provider.offers(): Boolean = offers(S::class)