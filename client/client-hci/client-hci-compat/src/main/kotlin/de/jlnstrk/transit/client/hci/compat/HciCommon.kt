package de.jlnstrk.transit.client.hci.compat

import de.jlnstrk.transit.client.hci.ksp.DefaultExpr

public data class HciCommon(
    @DefaultExpr("emptyList()") public val layerL: List<HciLayer> = emptyList(),
    @DefaultExpr("emptyList()") public val crdSysL: List<HciCoordSystem> = emptyList(),
)
