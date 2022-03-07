package de.jlnstrk.transit.client.hci.method.bookingdata

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.booking.HciBookingResult
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciBookingDataServiceResult(
  public val `data`: HciBookingResult? = null
) : HciServiceResult()
