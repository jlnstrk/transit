package de.jlnstrk.transit.common

import de.jlnstrk.transit.common.model.ProductClass

public interface Profile {
    public val filterConfig: Array<de.jlnstrk.transit.common.Profile.FilterEntry>
    public val brandingConfig: Array<ProductClass>

    public class FilterEntry(
        public vararg val products: ProductClass,
        public val isDefault: Boolean = false,
        public val styleOf: ProductClass = products[0]
    )
}