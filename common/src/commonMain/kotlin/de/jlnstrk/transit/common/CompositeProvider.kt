package de.jlnstrk.transit.common

import de.jlnstrk.transit.util.ZoneOffset
import kotlin.reflect.KClass

@DslMarker
internal annotation class CompositeDsl

public class CompositeProvider(
    private val delegates: MutableMap<KClass<out Service>, Provider> = HashMap()
) : Provider() {

    override val timezone: ZoneOffset
        get() = throw UnsupportedOperationException()

    override val services: Set<KClass<out Service>>
        get() = delegates.keys

    override fun <C : Service> service(serviceInterface: KClass<C>): C? {
        return delegates[serviceInterface]?.service(serviceInterface)
    }

    public fun useAll(delegate: Provider): CompositeProvider {
        for (serviceClass in delegate.services) {
            use(serviceClass, delegate)
        }
        return this
    }

    public fun <S : Service> use(
        service: KClass<S>,
        delegate: Provider,
    ): CompositeProvider {
        if (!delegate.offers(service)) {
            throw IllegalArgumentException("Provided delegate does not offer ${service.simpleName}")
        }
        delegates[service] = delegate
        return this
    }

    /** Use the services configured in [init] from [delegate] */
    public fun of(
        delegate: Provider,
        init: Delegate.() -> Unit
    ): CompositeProvider {
        Delegate(delegate).init()
        return this
    }

    public inner class Delegate internal constructor(private val delegate: Provider) {

        /** Configures [service] as implementation instance for [S] */
        public fun <S : Service> use(service: KClass<S>): Delegate {
            this@CompositeProvider.use(service, delegate)
            return this
        }
    }
}