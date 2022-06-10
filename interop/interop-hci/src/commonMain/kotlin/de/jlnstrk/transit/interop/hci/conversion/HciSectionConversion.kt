package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.client.hci.model.HciConSection
import de.jlnstrk.transit.client.hci.model.HciConSectionType
import de.jlnstrk.transit.common.model.Leg
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext
import kotlinx.datetime.LocalDate

internal fun HciConSection.asCommon(context: HciCommonContext, date: LocalDate): Leg? {
    return when (type) {
        HciConSectionType.JNY -> Leg.Public(
            departure = dep!!.departureAsCommon(context, date),
            arrival = arr!!.arrivalAsCommon(context, date),
            journey = jny!!.asCommon(context, date),
            alternatives = jny!!.freq?.jnyL?.map { it.asCommon(context, date) },
            frequency = jny!!.freq?.asCommon(context)
        )
        HciConSectionType.TRSF -> null // TODO: Proper transfer handling
        else -> Leg.Individual(
            departure = dep!!.departureAsCommon(context, date),
            arrival = arr!!.arrivalAsCommon(context, date),
            type = when (type) {
                HciConSectionType.WALK -> Leg.Individual.Type.WALK
                HciConSectionType.BIKE -> Leg.Individual.Type.BIKE
                HciConSectionType.KISS -> Leg.Individual.Type.CAR
                HciConSectionType.TAXI,
                HciConSectionType.TETA -> Leg.Individual.Type.TAXI
                else -> throw IllegalStateException()
            },
            gis = gis!!.asCommon(context)
        )
    }
}