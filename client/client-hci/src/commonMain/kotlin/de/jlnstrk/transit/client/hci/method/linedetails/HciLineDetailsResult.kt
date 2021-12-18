package de.jlnstrk.transit.client.hci.method.linedetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciLine
import de.jlnstrk.transit.client.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLineDetailsResult(
    public val line: HciLine?,
) : HciServiceResult()