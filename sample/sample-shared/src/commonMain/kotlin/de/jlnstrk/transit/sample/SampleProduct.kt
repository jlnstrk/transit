package de.jlnstrk.transit.sample

import de.jlnstrk.transit.common.model.TransportMode
import de.jlnstrk.transit.common.model.ProductClass

sealed interface SampleProduct : ProductClass {
    sealed interface RegionalTrain : SampleProduct {
        override val mode: TransportMode get() = TransportMode.TRAIN

        sealed interface Local : RegionalTrain
        sealed interface Express : RegionalTrain
    }

    // S-Bahn is a type of commuter rail used in most urban regions in Germany
    sealed interface SBahn : SampleProduct {
        override val mode: TransportMode get() = TransportMode.TRAIN

        interface Express : SBahn
    }

    interface ExpressBus : SampleProduct {
        override val mode: TransportMode get() = TransportMode.BUS
    }

    interface MetroBus : SampleProduct {
        override val mode: TransportMode get() = TransportMode.BUS
    }

    interface RegionalBus : SampleProduct {
        override val mode: TransportMode get() = TransportMode.BUS
    }
}

