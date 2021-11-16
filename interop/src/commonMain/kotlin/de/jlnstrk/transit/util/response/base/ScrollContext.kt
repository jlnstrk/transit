package de.jlnstrk.transit.util.response.base

public interface ScrollContext<T> {
    public val canScrollBackward: Boolean
    public val canScrollForward: Boolean

    public infix fun mergeWith(other: ScrollContext<T>): ScrollContext<T> = throw NotImplementedError()
}