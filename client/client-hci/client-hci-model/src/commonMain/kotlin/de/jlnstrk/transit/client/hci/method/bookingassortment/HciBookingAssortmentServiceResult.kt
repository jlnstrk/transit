package de.jlnstrk.transit.client.hci.method.bookingassortment

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.booking.HciBookingResult
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciBookingAssortmentServiceResult(
  public val `data`: HciBookingResult? = null,
) : HciServiceResult()
