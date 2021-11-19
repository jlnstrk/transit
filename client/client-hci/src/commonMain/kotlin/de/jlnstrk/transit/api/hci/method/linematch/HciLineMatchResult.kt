package de.jlnstrk.transit.api.hci.method.linematch

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciLine
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLineMatchResult(
    public val lineL: List<HciLine> = emptyList()
) : HciServiceResult()