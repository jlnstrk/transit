package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.api.efa.model.EfaCoordinates
import de.jlnstrk.transit.api.efa.model.EfaJourney
import de.jlnstrk.transit.api.efa.model.EfaLeg
import de.jlnstrk.transit.api.efa.model.EfaMode
import de.jlnstrk.transit.common.model.*
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.util.normalized

internal fun EfaLeg.normalize(provider: EfaProvider): Leg? {
    val isRealtime = mode.realtime || realtimeStatus == EfaJourney.RealtimeStatus.MONITORED
    val departure = points.first().normalizeAsDeparture(provider, isRealtime)
    val arrival = points.last().normalizeAsArrival(provider, isRealtime)
    return when (mode.type) {
        EfaMode.InterchangeType.Footway -> Leg.Individual(
            departure, arrival, Leg.Individual.Type.WALK, Gis(0, timeMinute, emptyList())
        )
        EfaMode.InterchangeType.Transfer -> Leg.Transfer(
            departure, arrival
        )
        EfaMode.InterchangeType.DoNotChange,
        EfaMode.InterchangeType.SecureConnection -> null
        is EfaMode.InterchangeType.Icon -> Leg.Public(
            departure, arrival, journey = Journey(
                stop = departure,
                directionTo = Location.Station(
                    name = mode.destination,
                    numericId = mode.destID!!
                ),
                stops = stopSeq.map { it.normalizeAsIntermediate(provider) },
                polyline = path.ifEmpty { null }
                    ?.let { Polyline(coordinates = it.map(EfaCoordinates::normalized)) },
                isReachable = true,
                isCancelled = realtimeStatus == EfaJourney.RealtimeStatus.TRIP_CANCELLED,
                isPartiallyCancelled = false,
                id = mode.diva.tripCode.toString(),
                line = mode.normalize(provider)
            ),
            alternatives = null,
            frequency = null
        )
    }
}