package de.jlnstrk.transit.util

import kotlin.reflect.KClass

public abstract class Provider : ReferenceTimezone {
    public abstract val services: Set<KClass<out Service>>

    public inline fun <reified C : Service> require(): C {
        return require(C::class)
    }

    public fun <C : Service> require(serviceClass: KClass<C>): C {
        return service(serviceClass)
            ?: throw IllegalArgumentException("Provider does not support ${serviceClass.simpleName}")
    }

    public inline fun <reified C : Service> optional(): C? {
        return optional(C::class)
    }

    public fun <C : Service> optional(serviceClass: KClass<C>): C? {
        return service(serviceClass)
    }

    public inline fun <reified C : Service> offers(): Boolean {
        return offers(C::class)
    }

    public open fun <C : Service> offers(serviceClass: KClass<C>): Boolean {
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