package de.jlnstrk.transit.common

public interface Service {

    public fun interface Factory<S : Service> {
        public fun create(): S
    }

    public abstract class Base<P : Provider.Implementation>(
        protected val provider: P
    ) : Service
}