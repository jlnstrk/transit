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

public suspend inline fun <reified DataSet : Any> ShouldSpecContainerScope.givenAll(
    from: ServiceTestProfile<*, *>,
    require: Boolean = true,
    crossinline test: suspend TestContext.(DataSet) -> Unit
) {
    val dataSets = from.testData[DataSet::class].orEmpty() as List<DataSet>
    if (dataSets.isEmpty()) {
        if (require) {
            throw IllegalStateException("No ${DataSet::class.simpleName} specified for ${from.name}")
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

public suspend inline fun <Profile : ServiceTestProfile<*, DataSet>, reified DataSet : Any> ShouldSpecContainerScope.givenOne(
    from: Profile,
    require: Boolean = true,
    crossinline test: suspend TestContext.(DataSet) -> Unit
) {
    val dataSet = from.testData[DataSet::class].orEmpty().firstOrNull()
    if (dataSet == null) {
        if (require) {
            throw IllegalStateException("No ${DataSet::class.simpleName} specified for ${from.name}")
        } else {
            println("${this::class.simpleName} did not run for ${from.name}")
        }
    } else {
        context("Given dataSet $dataSet") {
            test(dataSet)
        }
    }
}

