package de.jlnstrk.transit.client.hci.compat

import de.jlnstrk.transit.client.hci.ksp.DefaultExpr

public data class HciCoord(
    @DefaultExpr("0") public val layerX: Int = 0,
    @DefaultExpr("0") public val crdSysX: Int = 0,
)