package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.api.efa.model.*
import de.jlnstrk.transit.common.model.*
import de.jlnstrk.transit.interop.efa.EfaProvider

internal fun EfaTrip.normalize(provider: EfaProvider): Trip {
    val commonLegs = legs.mapNotNull { it.normalize(provider) }
    return Trip(
        literalId = null,
        numericId = 0L,
        legs = commonLegs,
        departure = commonLegs.first().departure,
        arrival = commonLegs.last().arrival,
        isRideable = true,
        frequency = null,
        schedule = null,
        refreshContext = null
    )
}