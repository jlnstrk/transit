package de.jlnstrk.transit.util

public interface Service {

    public fun interface Factory<S : Service> {
        public fun create(): S
    }

    public abstract class Base<P : Provider.Implementation>(
        protected val provider: P
    ) : Service
}