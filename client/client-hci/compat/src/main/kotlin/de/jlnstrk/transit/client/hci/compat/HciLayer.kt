package de.jlnstrk.transit.client.hci.compat

import de.jlnstrk.transit.client.hci.ksp.DefaultExpr

public data class HciLayer(
    @DefaultExpr("null") public val id: String? = null,
    @DefaultExpr("null") public val name: String? = null,
    @DefaultExpr("0") public val index: Int = 0,
    @DefaultExpr("0") public val annoCnt: Int = 0,
)