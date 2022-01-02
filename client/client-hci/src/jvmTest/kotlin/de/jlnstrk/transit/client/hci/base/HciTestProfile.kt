package de.jlnstrk.transit.client.hci.base

import de.jlnstrk.transit.client.hci.HciConfig
import de.jlnstrk.transit.client.hci.HciConsumer
import de.jlnstrk.transit.client.hci.profile.BVG
import de.jlnstrk.transit.client.hci.profile.HVV
import de.jlnstrk.transit.client.hci.profile.RMV
import de.jlnstrk.transit.client.hci.profile.SBM
import de.jlnstrk.transit.util.testing.ServiceTestProfile
import io.kotest.core.spec.style.scopes.ContainerScope
import io.kotest.core.spec.style.scopes.ShouldSpecContainerScope
import kotlin.reflect.KClass

class HciTestProfile(val name: String) {
    lateinit var config: HciConfig

    var testData = mutableMapOf<KClass<out TestData>, MutableList<TestData>>()
        private set



    fun testData(vararg data: TestData) {
        for (dataSet in data) {
            testData[dataSet::class]?.add(dataSet) ?: run {
                testData[dataSet::class] = mutableListOf(dataSet)
            }
        }
    }

    fun makeTestEndpoint(): HciConsumer {
        return HciConsumer(config, strict = true).apply {
            httpClient = httpClient.config {
                install(HciLogging)
            }
        }
    }

    interface TestData

    companion object {
        val ALL_PROFILES = listOf(BVG, HVV, SBM, RMV)

        operator fun invoke(name: String, init: HciTestProfile.() -> Unit): HciTestProfile =
            HciTestProfile(name).apply(init)
    }
}

suspend inline fun ShouldSpecContainerScope.forEach(
    crossinline require: HciTestProfile.() -> Boolean = { true },
    crossinline test: suspend ShouldSpecContainerScope.(HciTestProfile, HciConsumer) -> Unit
) {
    val profiles = HciTestProfile.ALL_PROFILES.filter { it.require() }
    for (profile in profiles) {
        context(profile.name) {
            val consumer = profile.makeTestEndpoint()
            test(profile, consumer)
        }
    }
}

public suspend inline fun <reified TestData : HciTestProfile.TestData> ShouldSpecContainerScope.given(
    from: HciTestProfile,
    using: HciConsumer = from.makeTestEndpoint(),
    crossinline test: suspend ContainerScope.(HciTestProfile, HciConsumer, TestData) -> Unit
) {
    return given<TestData>(from) { data ->
        test(from, using, data)
    }
}

public suspend inline fun <reified TestData : HciTestProfile.TestData> ShouldSpecContainerScope.given(
    from: HciTestProfile,
    crossinline test: suspend ContainerScope.(TestData) -> Unit
) {
    for (data in from.testData[TestData::class] as MutableList<TestData>) {
        context(data.toString()) {
            test(data)
        }
    }
}

public suspend inline fun <reified TestData : HciTestProfile.TestData> ShouldSpecContainerScope.forEachGiven(
    crossinline require: HciTestProfile.() -> Boolean = { true },
    crossinline test: suspend ContainerScope.(HciTestProfile, HciConsumer, TestData) -> Unit
) {
    forEach(require = require) { profile, consumer ->
        given(from = profile, using = consumer, test = test)
    }
}