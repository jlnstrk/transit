package de.jlnstrk.transit.api.hci.method.linedetails

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciLine
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLineDetailsResult(
    public val line: HciLine?,
) : HciServiceResult()