package de.jlnstrk.transit.sample

import de.jlnstrk.transit.common.model.TransportMode

sealed interface BerlinProduct : SampleProduct {
    object Bahn : BerlinProduct, SampleProduct.RegionalTrain
    object SBahn : BerlinProduct, SampleProduct.SBahn
    object UBahn : BerlinProduct {
        override val mode: TransportMode get() = TransportMode.BUS
    }
    object Tram : BerlinProduct {
        override val mode: TransportMode get() = TransportMode.LIGHT_RAIL
    }
    object ExpressBus : BerlinProduct, SampleProduct.ExpressBus
    object Bus : BerlinProduct {
        override val mode: TransportMode get() = TransportMode.BUS
    }
    object Faehre : BerlinProduct {
        override val mode: TransportMode get() = TransportMode.WATERCRAFT
    }
}