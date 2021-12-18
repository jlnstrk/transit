package de.jlnstrk.transit.client.efa.request

@DslMarker
internal annotation class EfaRequestDsl

/**
 * Base class for requests to EFA endpoints.
 * Implements string [Map] to be decomposable into query param key/value pairs
 */
@EfaRequestDsl
public abstract class EfaRequest internal constructor(
    override val queryMap: EfaRequestMap = EfaRequestMap()
) : Map<String, String> by queryMap, EfaRequestMapDelegate