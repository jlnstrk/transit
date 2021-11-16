package de.jlnstrk.transit.api.hci.method.himgeopos

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciHimGeoPosResult(
    public val edgeRefL: List<Int> = emptyList(),
    public val msgRefL: List<Int> = emptyList(),
    public val regionRefL: List<Int> = emptyList(),
    public val lastUpd: String? = null,
) : HciServiceResult()