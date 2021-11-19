package de.jlnstrk.transit.sample

import de.jlnstrk.transit.common.model.Means
import de.jlnstrk.transit.common.model.ProductClass

sealed interface SampleProduct : ProductClass {
    sealed interface RegionalTrain : SampleProduct {
        override val base: Means get() = Means.TRAIN

        sealed interface Local : RegionalTrain
        sealed interface Express : RegionalTrain
    }

    // S-Bahn is a type of commuter rail used in most urban regions in Germany
    sealed interface SBahn : SampleProduct {
        override val base: Means get() = Means.TRAIN

        interface Express : SBahn
    }

    interface ExpressBus : SampleProduct {
        override val base: Means get() = Means.BUS
    }

    interface MetroBus : SampleProduct {
        override val base: Means get() = Means.BUS
    }

    interface RegionalBus : SampleProduct {
        override val base: Means get() = Means.BUS
    }
}

