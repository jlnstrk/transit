package de.jlnstrk.transit.util.testing

import kotlin.reflect.KClass

public interface ServiceTestProfile<Endpoint, DataSet> {
    public val name: String
    public val testData: Map<KClass<*>, List<DataSet>> get() = emptyMap()
    public fun makeTestEndpoint(): Endpoint
}