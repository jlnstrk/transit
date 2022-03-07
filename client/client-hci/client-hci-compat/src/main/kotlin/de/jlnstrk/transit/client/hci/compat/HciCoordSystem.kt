package de.jlnstrk.transit.client.hci.compat

import de.jlnstrk.transit.client.hci.HciCompat
import de.jlnstrk.transit.client.hci.ksp.DefaultExpr
import de.jlnstrk.transit.client.hci.model.HciCoordType

public data class HciCoordSystem(
    @DefaultExpr("null") public val id: String? = null,
    @DefaultExpr("null") public val name: String? = null,
    @DefaultExpr("null") public val picture: String? = null,
    @DefaultExpr("0") public val index: Int = 0,
    @DefaultExpr("HciCoordType.WGS_84") public val type: HciCoordType = HciCoordType.WGS_84,
    @DefaultExpr("0") public val dim: Int = 0,
)
