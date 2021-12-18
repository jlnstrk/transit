package de.jlnstrk.transit.client.efa

import de.jlnstrk.transit.client.efa.model.EfaMeansOfTransport

public fun interface EfaIconCodeResolver {
    public fun resolveIconCode(iconCode: Int): EfaMeansOfTransport?
}