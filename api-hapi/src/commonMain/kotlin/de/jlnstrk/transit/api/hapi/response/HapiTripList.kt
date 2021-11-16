package de.jlnstrk.transit.api.hapi.response

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.tariff.HapiPricing
import de.jlnstrk.transit.api.hapi.model.trip.HapiTrip
import de.jlnstrk.transit.api.hapi.response.base.HapiResponse
import de.jlnstrk.transit.api.hapi.serializer.HapiListUnwrapSerializer
import kotlinx.serialization.Serializable

/** The trip list contains all found trips of that trip request. If a major error occurred during the trip request,
 * then the attributes errorCode and errorText are filled and no Trip is available. */
@HapiXsd("1.29")
@Serializable
public data class HapiTripList(
    /** The context for scroll request backward.
     * Set the context attribute in a Trip request for finding earlier connections. */
    public val scrB: String?,
    /** The context for scroll request forward.
     * Set the context attribute in a Trip request for finding later connections. */
    public val scrF: String?,
    /** The context for scroll request backward for returning trips.
     * Set the context attribute in a Trip request for finding earlier connections. */
    public val scrReturnB: String?,
    /** The context for scroll request forward for returning trips.
     * Set the context attribute in a Trip request for finding later connections. */
    public val scrReturnF: String?,

    public val Trip: List<HapiTrip> = emptyList(),
    @Serializable(with = HapiListUnwrapSerializer::class)
    public val Pricing: List<HapiPricing> = emptyList(),
) : HapiResponse()