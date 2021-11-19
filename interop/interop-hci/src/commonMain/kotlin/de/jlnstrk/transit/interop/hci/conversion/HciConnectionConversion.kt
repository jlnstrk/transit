package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.api.hci.model.connection.HciConnection
import de.jlnstrk.transit.common.model.Trip
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal fun HciConnection.asCommon(context: HciCommonContext): Trip {
    return Trip(
        literalId = ctxRecon,
        numericId = ctxRecon.hashCode().toLong(),
        departure = dep.departureAsCommon(context, date),
        arrival = arr.arrivalAsCommon(context, date),
        legs = secL.mapNotNull { it.asCommon(context, date) },
        isRideable = isNotRdbl != true,
        frequency = freq?.asCommon(context),
    )
}