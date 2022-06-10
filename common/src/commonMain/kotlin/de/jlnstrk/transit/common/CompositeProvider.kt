package de.jlnstrk.transit.common

import kotlinx.datetime.TimeZone
import kotlin.reflect.KClass

public class CompositeProvider private constructor(
    private val delegates: MutableMap<KClass<out Service>, Provider> = HashMap()
) : Provider() {

    override val timezone: TimeZone
        get() = throw UnsupportedOperationException()

    override val services: Set<KClass<out Service>>
        get() = delegates.keys

    override fun <C : Service> service(serviceInterface: KClass<C>): C? {
        return delegates[serviceInterface]?.service(serviceInterface)
    }

    public fun useAll(from: Provider) {
        for (serviceClass in from.services) {
            use(serviceClass, from)
        }
    }

    public fun <S : Service> use(
        service: KClass<S>,
        from: Provider,
    ) {
        if (!from.offers(service)) {
            throw IllegalArgumentException("Provided delegate does not offer ${service.simpleName}")
        }
        delegates[service] = from
    }

    /** Use the services configured in [init] from [delegate] */
    public fun of(
        delegate: Provider,
        init: Delegate.() -> Unit
    ) {
        Delegate(delegate).init()
    }

    public inner class Delegate internal constructor(private val delegate: Provider) {

        /** Configures [service] as implementation instance for [S] */
        public fun <S : Service> use(service: KClass<S>) {
            this@CompositeProvider.use(service, delegate)
        }
    }

    public companion object {
        public operator fun invoke(init: CompositeProvider.() -> Unit): CompositeProvider =
            CompositeProvider().apply(init)
    }
}