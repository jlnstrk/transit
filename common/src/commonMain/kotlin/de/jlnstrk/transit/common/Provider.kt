package de.jlnstrk.transit.common

import de.jlnstrk.transit.common.normalize.Normalization
import kotlin.reflect.KClass

public abstract class Provider : ReferenceTimezone {
    public abstract val services: Set<KClass<out Service>>

    /** Returns the implementation instance for [serviceClass].
     * @throws IllegalArgumentException if no such instance was provided */
    public fun <S : Service> require(serviceClass: KClass<S>): S {
        return service(serviceClass)
            ?: throw IllegalArgumentException("Provider does not support ${serviceClass.simpleName}")
    }

    /** Returns the implementation instance for [serviceClass] if provided. */
    public fun <S : Service> optional(serviceClass: KClass<S>): S? {
        return service(serviceClass)
    }

    /** Returns whether this [Provider] has a provided implementation instance for [serviceClass]. */
    public open fun <S : Service> offers(serviceClass: KClass<S>): Boolean {
        return services.contains(serviceClass)
    }

    @PublishedApi
    internal abstract fun <S : Service> service(serviceInterface: KClass<S>): S?

    public abstract class Implementation : Provider(), Normalization {
        private val factories: MutableMap<KClass<out Service>, Service.Factory<*>> = HashMap()
        private val instances: MutableMap<KClass<out Service>, Service> = HashMap()

        override val services: Set<KClass<out Service>>
            get() = factories.keys

        @Suppress("UNCHECKED_CAST")
        final override fun <S : Service> service(serviceInterface: KClass<S>): S? {
            val cached = instances[serviceInterface]
            if (cached != null) {
                return cached as S
            }
            val created = factories[serviceInterface]?.create()
            if (created != null) {
                instances[serviceInterface] = created
                return created as S
            }
            return null
        }

        @PublishedApi
        internal fun <S : Service, R : S> registerService(
            abstractService: KClass<S>,
            factory: Service.Factory<R>
        ) {
            factories[abstractService] = factory
        }

        protected inline fun <reified S : Service> registerService(factory: Service.Factory<S>) {
            registerService(S::class, factory)
        }
    }
}