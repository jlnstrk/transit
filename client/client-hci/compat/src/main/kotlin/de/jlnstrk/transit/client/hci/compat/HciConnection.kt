package de.jlnstrk.transit.client.hci.compat

import de.jlnstrk.transit.client.hci.ksp.DefaultExpr

public data class HciConnection(
    @DefaultExpr("null") public val ctxRecon: String? = null
)