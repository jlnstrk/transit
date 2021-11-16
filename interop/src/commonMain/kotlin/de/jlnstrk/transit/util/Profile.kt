package de.jlnstrk.transit.util

import de.jlnstrk.transit.util.model.ProductClass

public interface Profile {
    public val filterConfig: Array<FilterEntry>
    public val brandingConfig: Array<ProductClass>

    public class FilterEntry(
        public vararg val products: ProductClass,
        public val isDefault: Boolean = false,
        public val styleOf: ProductClass = products[0]
    )
}