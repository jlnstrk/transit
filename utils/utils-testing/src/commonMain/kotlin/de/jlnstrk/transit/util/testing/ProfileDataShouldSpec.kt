package de.jlnstrk.transit.util.testing

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.core.spec.style.scopes.ShouldSpecContainerScope
import io.kotest.core.test.TestContext
import kotlinx.coroutines.delay

public abstract class ProfileDataShouldSpec<Endpoint : Any, Profile : ServiceTestProfile<Endpoint, *>>(
    allProfiles: List<Profile>,
    test: suspend ShouldSpecContainerScope.(Endpoint, Profile) -> Unit
) :
    ShouldSpec(spec@{
        for (profile in allProfiles) {
            val client = profile.makeTestEndpoint()
            context("For profile ${profile.name}") {
                test(client, profile)
            }
        }
    }) {
}

public suspend inline fun <reified TestData : Any> ShouldSpecContainerScope.givenAll(
    from: ServiceTestProfile<*, *>,
    require: Boolean = true,
    crossinline test: suspend TestContext.(TestData) -> Unit
) {
    val dataSets = from.testData[TestData::class].orEmpty() as List<TestData>
    if (dataSets.isEmpty()) {
        if (require) {
            throw IllegalStateException("No ${TestData::class.simpleName} specified for ${from.name}")
        } else {
            println("${this::class.simpleName} did not run for ${from.name}")
        }
    }
    for (dataSet in dataSets) {
        context("Given dataSet $dataSet") {
            test(dataSet)
        }
        delay(500)
    }
}

public suspend inline fun <Profile : ServiceTestProfile<*, TestData>, reified TestData : Any> ShouldSpecContainerScope.givenOne(
    from: Profile,
    require: Boolean = true,
    crossinline test: suspend TestContext.(TestData) -> Unit
) {
    val dataSet = from.testData[TestData::class].orEmpty().firstOrNull()
    if (dataSet == null) {
        if (require) {
            throw IllegalStateException("No ${TestData::class.simpleName} specified for ${from.name}")
        } else {
            println("${this::class.simpleName} did not run for ${from.name}")
        }
    } else {
        context("Given test data $dataSet") {
            test(dataSet)
        }
    }
}

