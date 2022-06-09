package de.jlnstrk.transit.interop.efa.normalization

import de.jlnstrk.transit.client.efa.model.EfaMeansOfTransport
import de.jlnstrk.transit.common.model.TransportMode
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
                EfaMeansOfTransport.COMMUTER_RAILWAY -> TransportMode.TRAIN
                EfaMeansOfTransport.SUBWAY -> TransportMode.SUBWAY
                EfaMeansOfTransport.CITY_RAIL,
                EfaMeansOfTransport.TRAM -> TransportMode.LIGHT_RAIL
                EfaMeansOfTransport.CITY_BUS,
                EfaMeansOfTransport.REGIONAL_BUS,
                EfaMeansOfTransport.EXPRESS_BUS,
                EfaMeansOfTransport.CIVIL_BUS -> TransportMode.BUS
                EfaMeansOfTransport.FERRY -> TransportMode.WATERCRAFT
                EfaMeansOfTransport.TAXI_ON_DEMAND -> TransportMode.CAR
                EfaMeansOfTransport.CABLE_CAR -> TransportMode.CABLE
                EfaMeansOfTransport.AIRPLANE,
                EfaMeansOfTransport.REPLACEMENT_SERVICE,
                EfaMeansOfTransport.RAIL_SHUTTLE,
                EfaMeansOfTransport.OTHER -> TransportMode.OTHER
            }
        }

        override fun denormalizeEfaMeans(productClass: ProductClass): EfaMeansOfTransport {
            return when (productClass) {
                TransportMode.TRAIN -> EfaMeansOfTransport.TRAIN
                TransportMode.SUBWAY -> EfaMeansOfTransport.SUBWAY
                TransportMode.LIGHT_RAIL -> EfaMeansOfTransport.CITY_RAIL
                TransportMode.CABLE -> EfaMeansOfTransport.CABLE_CAR
                TransportMode.BUS -> EfaMeansOfTransport.CITY_BUS
                TransportMode.WATERCRAFT -> EfaMeansOfTransport.FERRY
                TransportMode.CAR -> EfaMeansOfTransport.RAIL_SHUTTLE
                TransportMode.OTHER -> EfaMeansOfTransport.OTHER
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
                    TransportMode.TRAIN -> {
                        set.add(EfaMeansOfTransport.TRAIN)
                        set.add(EfaMeansOfTransport.TRAIN_INTERCITY)
                        set.add(EfaMeansOfTransport.TRAIN_INTERCITY_SURCHARGE)
                        set.add(EfaMeansOfTransport.TRAIN_INTERCITY_SPECIAL_FARE)
                        set.add(EfaMeansOfTransport.TRAIN_LOCAL)
                        set.add(EfaMeansOfTransport.COMMUTER_RAILWAY)
                    }
                    TransportMode.SUBWAY -> {
                        set.add(EfaMeansOfTransport.SUBWAY)
                    }
                    TransportMode.LIGHT_RAIL -> {
                        set.add(EfaMeansOfTransport.CITY_RAIL)
                        set.add(EfaMeansOfTransport.TRAM)
                    }
                    TransportMode.CABLE -> {
                        set.add(EfaMeansOfTransport.CABLE_CAR)
                    }
                    TransportMode.BUS -> {
                        set.add(EfaMeansOfTransport.CITY_BUS)
                        set.add(EfaMeansOfTransport.REGIONAL_BUS)
                        set.add(EfaMeansOfTransport.CIVIL_BUS)
                        set.add(EfaMeansOfTransport.EXPRESS_BUS)
                    }
                    TransportMode.WATERCRAFT -> {
                        set.add(EfaMeansOfTransport.FERRY)
                    }
                    TransportMode.CAR -> {
                        set.add(EfaMeansOfTransport.RAIL_SHUTTLE)
                    }
                    TransportMode.OTHER -> {
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