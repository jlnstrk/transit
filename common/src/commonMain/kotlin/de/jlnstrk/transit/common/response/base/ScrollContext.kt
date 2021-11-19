package de.jlnstrk.transit.common.response.base

public interface ScrollContext<T> {
    public val canScrollBackward: Boolean
    public val canScrollForward: Boolean
}