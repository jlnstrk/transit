package de.jlnstrk.transit.client.hci.compat

import de.jlnstrk.transit.client.hci.HciCompat
import de.jlnstrk.transit.client.hci.ksp.DefaultExpr

public data class HciJourneyStop(
    @HciCompat(removedAfter = "1.21", removedBefore = "1.24")
    @DefaultExpr("null")
    public val aPlatfS: String? = null,

    @HciCompat(removedAfter = "1.21", removedBefore = "1.24")
    @DefaultExpr("null")
    public val aPlatfR: String? = null,

    @HciCompat(removedAfter = "1.21", removedBefore = "1.24")
    @DefaultExpr("null")
    public val dPlatfS: String? = null,

    @HciCompat(removedAfter = "1.21", removedBefore = "1.24")
    @DefaultExpr("null")
    public val dPlatfR: String? = null,
)