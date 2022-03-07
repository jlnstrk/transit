package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.client.hci.model.connection.HciConnection
import de.jlnstrk.transit.common.model.Trip
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal fun HciConnection.asCommon(context: HciCommonContext): Trip {
    val reconstructionContext = recon?.ctx ?: ctxRecon
    return Trip(
        id = reconstructionContext.orEmpty(),
        departure = dep!!.departureAsCommon(context, date!!),
        arrival = arr!!.arrivalAsCommon(context, date!!),
        legs = secL.mapNotNull { it.asCommon(context, date!!) },
        isRideable = !isNotRdbl,
        frequency = freq?.asCommon(context),
    )
}