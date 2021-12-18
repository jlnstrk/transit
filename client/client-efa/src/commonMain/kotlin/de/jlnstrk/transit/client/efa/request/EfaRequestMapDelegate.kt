package de.jlnstrk.transit.client.efa.request

public interface EfaRequestMapDelegate {
    public val queryMap: EfaRequestMap

    public abstract class Nested internal constructor(outer: EfaRequestMapDelegate) :
        EfaRequestMapDelegate by outer
}