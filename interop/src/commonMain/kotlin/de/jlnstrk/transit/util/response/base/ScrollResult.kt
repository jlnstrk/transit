package de.jlnstrk.transit.util.response.base

public data class ScrollResult<D>(
    public val data: D,
    public val isForwardScroll: Boolean
) where D : ServiceResult.Data, D : ScrollableData<D>