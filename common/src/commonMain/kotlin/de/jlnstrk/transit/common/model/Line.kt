package de.jlnstrk.transit.common.model

public data class Line(
    public val label: String,
    public val product: ProductClass = Means.OTHER,
    public val id: String? = null,
    public val name: String? = null,
    public val shortName: String? = null,
    public val number: String? = null,
    public val operator: String? = null,
    public val admin: String? = null
) : Comparable<Line> {

    override fun compareTo(other: Line): Int {
        val productCompare = product.base.compareTo(other.product.base)
        if (productCompare != 0)
            return productCompare
        return label.compareTo(other.label)
    }
}
