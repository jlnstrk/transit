package de.jlnstrk.transit.api.efa.endpoint.trip

import de.jlnstrk.transit.api.efa.model.EfaTrip
import de.jlnstrk.transit.api.efa.response.EfaMessage
import de.jlnstrk.transit.api.efa.response.EfaPointVerification
import de.jlnstrk.transit.api.efa.response.EfaTimetableResponse
import de.jlnstrk.transit.api.efa.serializer.EfaMessageSerializer
import kotlinx.serialization.Serializable

@Serializable
public class EfaTripResponse(
    public val itdMessageList: List<@Serializable(with = EfaMessageSerializer.WithUnwrap::class) EfaMessage>,
    public val origin: EfaPointVerification,
    public val destination: EfaPointVerification,
    public val via: EfaPointVerification?,
    public val addOdvs: String? = null,
    public val trips: List<EfaTrip> = emptyList()
) : EfaTimetableResponse()