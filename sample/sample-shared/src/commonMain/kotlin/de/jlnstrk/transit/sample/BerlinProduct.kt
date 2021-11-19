package de.jlnstrk.transit.sample

import de.jlnstrk.transit.common.model.Means

sealed interface BerlinProduct : SampleProduct {
    object Bahn : BerlinProduct, SampleProduct.RegionalTrain
    object SBahn : BerlinProduct, SampleProduct.SBahn
    object UBahn : BerlinProduct {
        override val base: Means get() = Means.BUS
    }
    object Tram : BerlinProduct {
        override val base: Means get() = Means.LIGHT_RAIL
    }
    object ExpressBus : BerlinProduct, SampleProduct.ExpressBus
    object Bus : BerlinProduct {
        override val base: Means get() = Means.BUS
    }
    object Faehre : BerlinProduct {
        override val base: Means get() = Means.WATERCRAFT
    }
}