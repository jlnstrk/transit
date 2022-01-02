package de.jlnstrk.transit.util.testing

import kotlin.reflect.KClass

public interface ServiceTestProfile<Endpoint, TestData : Any> {
    public val name: String
    public val testData: Map<KClass<out TestData>, List<TestData>> get() = emptyMap()
    public fun makeTestEndpoint(): Endpoint
}