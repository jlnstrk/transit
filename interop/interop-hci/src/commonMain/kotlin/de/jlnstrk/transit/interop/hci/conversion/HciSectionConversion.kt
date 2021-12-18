package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.client.hci.model.HciSection
import de.jlnstrk.transit.common.model.Leg
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext
import de.jlnstrk.transit.util.LocalDate

internal fun HciSection.asCommon(context: HciCommonContext, date: LocalDate): Leg? {
    return when (type) {
        HciSection.Type.JNY -> Leg.Public(
            departure = dep.departureAsCommon(context, date),
            arrival = arr.arrivalAsCommon(context, date),
            journey = jny!!.asCommon(context, date),
            alternatives = jny!!.freq?.jnyL?.map { it.asCommon(context, date) },
            frequency = jny!!.freq?.asCommon(context)
        )
        HciSection.Type.TRSF -> null // TODO: Proper transfer handling
        else -> Leg.Individual(
            departure = dep.departureAsCommon(context, date),
            arrival = arr.arrivalAsCommon(context, date),
            type = when (type) {
                HciSection.Type.WALK -> Leg.Individual.Type.WALK
                HciSection.Type.BIKE -> Leg.Individual.Type.BIKE
                HciSection.Type.KISS -> Leg.Individual.Type.CAR
                HciSection.Type.TAXI,
                HciSection.Type.TETA -> Leg.Individual.Type.TAXI
                else -> throw IllegalStateException()
            },
            gis = gis!!.asCommon(context)
        )
    }
}