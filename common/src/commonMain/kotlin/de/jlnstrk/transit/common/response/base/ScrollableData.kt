package de.jlnstrk.transit.common.response.base

public interface ScrollableData<D> where D : ServiceResult.Data, D : ScrollableData<D> {
    public val scrollContext: ScrollContext<D>?
}