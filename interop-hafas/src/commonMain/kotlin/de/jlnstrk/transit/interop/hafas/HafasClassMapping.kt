package de.jlnstrk.transit.interop.hafas

import de.jlnstrk.transit.common.model.ProductClass
import de.jlnstrk.transit.interop.hafas.extensions.log2

public interface HafasClassMapping {

    public fun singleFromClass(from: Int): ProductClass

    public fun singleToClass(from: ProductClass): Int

    public fun setFromBitmask(from: Int): Set<ProductClass>

    public fun setToBitmask(from: Set<ProductClass>): Int

    /**
     * A standard implementation that relies on [Simple.mapping]
     * to indicate product classes
     */
    public interface Simple : HafasClassMapping {
        public val mapping: Array<ProductClass>

        override fun singleFromClass(from: Int): ProductClass = mapping[from.log2()]

        override fun singleToClass(from: ProductClass): Int = mapping.indexOf(from)

        override fun setFromBitmask(from: Int): Set<ProductClass> {
            val set = mutableSetOf<ProductClass>()
            var mask = from
            var power = 0
            do {
                if (mask and 1 == 1 && mapping.size > power) {
                    mapping[power].let(set::add)
                }
                power++
                mask = mask ushr 1
            } while (mask != 0)
            return set
        }

        override fun setToBitmask(from: Set<ProductClass>): Int {
            var mask = 0
            for (cat in from) {
                for (i in mapping.indices) {
                    if (mapping[i] == cat) {
                        mask += 1 shl i
                        // no break, we're supporting 1:N
                    }
                }
            }
            return mask
        }
    }
}