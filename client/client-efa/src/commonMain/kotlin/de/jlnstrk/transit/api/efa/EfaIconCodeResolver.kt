package de.jlnstrk.transit.api.efa

import de.jlnstrk.transit.api.efa.model.EfaMeansOfTransport

public fun interface EfaIconCodeResolver {
    public fun resolveIconCode(iconCode: Int): EfaMeansOfTransport?
}