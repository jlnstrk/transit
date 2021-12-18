package de.jlnstrk.transit.client.hci.method.linematch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciLine
import de.jlnstrk.transit.client.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLineMatchResult(
    public val lineL: List<HciLine> = emptyList()
) : HciServiceResult()