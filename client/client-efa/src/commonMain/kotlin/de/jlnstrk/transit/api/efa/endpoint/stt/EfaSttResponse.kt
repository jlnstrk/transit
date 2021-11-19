package de.jlnstrk.transit.api.efa.endpoint.stt

import de.jlnstrk.transit.api.efa.endpoint.dm.EfaLineEntry
import de.jlnstrk.transit.api.efa.model.EfaDownload
import de.jlnstrk.transit.api.efa.response.EfaPointVerification
import de.jlnstrk.transit.api.efa.response.EfaResponse
import de.jlnstrk.transit.api.efa.serializer.EfaListUnwrapSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class EfaSttResponse(
    @SerialName("") // Why?
    public val stt: EfaPointVerification,
    @Serializable(with = EfaListUnwrapSerializer::class)
    public val servingLines: List<EfaLineEntry> = emptyList(),
    public val itdDownload: EfaDownload?,
) : EfaResponse()