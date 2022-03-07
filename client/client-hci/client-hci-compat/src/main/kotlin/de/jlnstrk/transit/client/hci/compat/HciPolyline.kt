package de.jlnstrk.transit.client.hci.compat

import de.jlnstrk.transit.client.hci.ksp.DefaultExpr

public data class HciPolyline(
    @DefaultExpr("emptyList()") public val crd: List<Double> = emptyList()
)