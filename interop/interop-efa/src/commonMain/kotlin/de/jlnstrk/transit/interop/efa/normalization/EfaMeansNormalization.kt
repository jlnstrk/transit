package de.jlnstrk.transit.interop.efa.normalization

import de.jlnstrk.transit.client.efa.model.EfaMeansOfTransport
import de.jlnstrk.transit.common.model.Means
import de.jlnstrk.transit.common.model.ProductClass

public interface EfaMeansNormalization {

    public fun resolveAltCode(from: Int): EfaMeansOfTransport? = null

    public fun normalizeEfaMeans(means: EfaMeansOfTransport): ProductClass

    public fun normalizeEfaMeans(means: Set<EfaMeansOfTransport>): Set<ProductClass>

    public fun denormalizeEfaMeans(productClass: ProductClass): EfaMeansOfTransport

    public fun denormalizeEfaMeans(productClasses: Set<ProductClass>): Set<EfaMeansOfTransport>

    public interface Simple : EfaMeansNormalization {
        public val baseMap: MeansBiMap? get() = null

        override fun normalizeEfaMeans(means: EfaMeansOfTransport): ProductClass {
            if (baseMap != null) {
                val resolved = baseMap!![means]
                if (resolved != null) {
                    return resolved
                }
            }
            return when (means) {
                EfaMeansOfTransport.TRAIN,
                EfaMeansOfTransport.TRAIN_INTERCITY,
                EfaMeansOfTransport.TRAIN_INTERCITY_SURCHARGE,
                EfaMeansOfTransport.TRAIN_INTERCITY_SPECIAL_FARE,
                EfaMeansOfTransport.TRAIN_LOCAL,
                EfaMeansOfTransport.COMMUTER_RAILWAY -> Means.TRAIN
                EfaMeansOfTransport.SUBWAY -> Means.SUBWAY
                EfaMeansOfTransport.CITY_RAIL,
                EfaMeansOfTransport.TRAM -> Means.LIGHT_RAIL
                EfaMeansOfTransport.CITY_BUS,
                EfaMeansOfTransport.REGIONAL_BUS,
                EfaMeansOfTransport.EXPRESS_BUS,
                EfaMeansOfTransport.CIVIL_BUS -> Means.BUS
                EfaMeansOfTransport.FERRY -> Means.WATERCRAFT
                EfaMeansOfTransport.TAXI_ON_DEMAND -> Means.CAR
                EfaMeansOfTransport.CABLE_CAR -> Means.CABLE
                EfaMeansOfTransport.AIRPLANE,
                EfaMeansOfTransport.REPLACEMENT_SERVICE,
                EfaMeansOfTransport.RAIL_SHUTTLE,
                EfaMeansOfTransport.OTHER -> Means.OTHER
            }
        }

        override fun denormalizeEfaMeans(productClass: ProductClass): EfaMeansOfTransport {
            return when (productClass) {
                Means.TRAIN -> EfaMeansOfTransport.TRAIN
                Means.SUBWAY -> EfaMeansOfTransport.SUBWAY
                Means.LIGHT_RAIL -> EfaMeansOfTransport.CITY_RAIL
                Means.CABLE -> EfaMeansOfTransport.CABLE_CAR
                Means.BUS -> EfaMeansOfTransport.CITY_BUS
                Means.WATERCRAFT -> EfaMeansOfTransport.FERRY
                Means.CAR -> EfaMeansOfTransport.RAIL_SHUTTLE
                Means.OTHER -> EfaMeansOfTransport.OTHER
                else -> {
                    if (baseMap != null) {
                        val resolved = baseMap!![productClass]
                        if (resolved != null) {
                            return resolved
                        }
                    }
                    println("EFA interop: denormalizeEfaMeans: Missing conversion for $productClass")
                    EfaMeansOfTransport.OTHER
                }
            }
        }

        override fun normalizeEfaMeans(means: Set<EfaMeansOfTransport>): Set<ProductClass> {
            return means.map(::normalizeEfaMeans)
                .toSet()
        }

        override fun denormalizeEfaMeans(productClasses: Set<ProductClass>): MutableSet<EfaMeansOfTransport> {
            val set = mutableSetOf<EfaMeansOfTransport>()
            for (productClass in productClasses) {
                when (productClass) {
                    Means.TRAIN -> {
                        set.add(EfaMeansOfTransport.TRAIN)
                        set.add(EfaMeansOfTransport.TRAIN_INTERCITY)
                        set.add(EfaMeansOfTransport.TRAIN_INTERCITY_SURCHARGE)
                        set.add(EfaMeansOfTransport.TRAIN_INTERCITY_SPECIAL_FARE)
                        set.add(EfaMeansOfTransport.TRAIN_LOCAL)
                        set.add(EfaMeansOfTransport.COMMUTER_RAILWAY)
                    }
                    Means.SUBWAY -> {
                        set.add(EfaMeansOfTransport.SUBWAY)
                    }
                    Means.LIGHT_RAIL -> {
                        set.add(EfaMeansOfTransport.CITY_RAIL)
                        set.add(EfaMeansOfTransport.TRAM)
                    }
                    Means.CABLE -> {
                        set.add(EfaMeansOfTransport.CABLE_CAR)
                    }
                    Means.BUS -> {
                        set.add(EfaMeansOfTransport.CITY_BUS)
                        set.add(EfaMeansOfTransport.REGIONAL_BUS)
                        set.add(EfaMeansOfTransport.CIVIL_BUS)
                        set.add(EfaMeansOfTransport.EXPRESS_BUS)
                    }
                    Means.WATERCRAFT -> {
                        set.add(EfaMeansOfTransport.FERRY)
                    }
                    Means.CAR -> {
                        set.add(EfaMeansOfTransport.RAIL_SHUTTLE)
                    }
                    Means.OTHER -> {
                        set.add(EfaMeansOfTransport.CABLE_CAR)
                        set.add(EfaMeansOfTransport.AIRPLANE)
                        set.add(EfaMeansOfTransport.REPLACEMENT_SERVICE)
                        set.add(EfaMeansOfTransport.OTHER)
                    }
                    else -> {
                        set.add(denormalizeEfaMeans(productClass))
                    }
                }
            }
            return set
        }

        public class MeansBiMap(vararg pairs: Pair<EfaMeansOfTransport, ProductClass>) {
            private val meansKeyed = mutableMapOf<EfaMeansOfTransport, ProductClass>()
            private val classKeyed = mutableMapOf<ProductClass, EfaMeansOfTransport>()

            init {
                for ((a, b) in pairs) {
                    set(a, b)
                }
            }

            public operator fun get(means: EfaMeansOfTransport): ProductClass? = meansKeyed[means]

            public operator fun get(productClass: ProductClass): EfaMeansOfTransport? =
                classKeyed[productClass]

            public operator fun set(means: EfaMeansOfTransport, productClass: ProductClass) {
                meansKeyed[means] = productClass
                classKeyed[productClass] = means
            }

            public operator fun set(productClass: ProductClass, means: EfaMeansOfTransport) {
                meansKeyed[means] = productClass
                classKeyed[productClass] = means
            }
        }
    }
}