package de.jlnstrk.transit.util.model

public data class Line(
    public var label: String,
    public var product: ProductClass = Means.OTHER,
    public var id: String? = null,
    public var name: String? = null,
    public var shortName: String? = null,
    public var number: String? = null,
    public var operator: String? = null,
    public var admin: String? = null
) : Comparable<Line> {

    override fun compareTo(other: Line): Int {
        val productCompare = product.base.compareTo(other.product.base)
        if (productCompare != 0)
            return productCompare
        return label.compareTo(other.label)
    }
}
