package de.jlnstrk.transit.util.composite

import de.jlnstrk.transit.util.Provider
import de.jlnstrk.transit.util.Service
import de.jlnstrk.transit.util.ZoneOffset
import kotlin.reflect.KClass

@CompositeDsl
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

    public inline fun <reified S : Service> use(
        delegate: Provider,
    ): CompositeProvider {
        return use(S::class, delegate)
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

    public fun of(
        delegate: Provider,
        init: Delegate.() -> Unit
    ): CompositeProvider {
        Delegate(delegate).init()
        return this
    }

    @CompositeDsl
    public inner class Delegate internal constructor(private val delegate: Provider) {

        public inline fun <reified S : Service> use(): Delegate {
            return use(S::class)
        }

        public fun <S : Service> use(service: KClass<S>): Delegate {
            this@CompositeProvider.use(service, delegate)
            return this
        }
    }

}