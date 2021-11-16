package de.jlnstrk.transit.api.hci.method.locgraph

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciLine
import de.jlnstrk.transit.api.hci.model.HciProductGraph
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocGraphResult(
    public val lineL: List<HciLine> = emptyList(),
    public val prodGraphL: List<HciProductGraph> = emptyList(),
    public val locStartEndRefL: List<Int> = emptyList(),
    public val locStopRefL: List<Int> = emptyList(),
) : HciServiceResult()