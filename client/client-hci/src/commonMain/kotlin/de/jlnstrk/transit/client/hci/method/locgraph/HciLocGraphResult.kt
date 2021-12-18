package de.jlnstrk.transit.client.hci.method.locgraph

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciLine
import de.jlnstrk.transit.client.hci.model.HciProductGraph
import de.jlnstrk.transit.client.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocGraphResult(
    public val lineL: List<HciLine> = emptyList(),
    public val prodGraphL: List<HciProductGraph> = emptyList(),
    public val locStartEndRefL: List<Int> = emptyList(),
    public val locStopRefL: List<Int> = emptyList(),
) : HciServiceResult()