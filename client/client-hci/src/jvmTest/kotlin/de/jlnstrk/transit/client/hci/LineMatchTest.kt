package de.jlnstrk.transit.client.hci

import de.jlnstrk.transit.client.hci.base.*
import de.jlnstrk.transit.client.hci.method.linematch.HciLineMatchServiceRequest
import de.jlnstrk.transit.client.hci.method.linematch.HciLineMatchServiceResult
import de.jlnstrk.transit.client.hci.model.HciLine
import de.jlnstrk.transit.util.testing.givenAll
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.collections.shouldHaveSingleElement
import io.kotest.matchers.collections.shouldNotHaveSingleElement



internal class LineMatchTest : ShouldSpec({
    context("LineMatch") {
        forEach { profile, consumer ->
            given<TestData.FindSelf>(from = profile) { data ->
                val request = HciLineMatchServiceRequest(data.findSelfInput)
                val result = consumer.serviceRequest<HciLineMatchServiceResult>(request)
                result!!.lineL shouldHaveSingleElement nameMatches(result, data.findSelfInput)
            }
            given<TestData.FindOthersOnly>(from = profile) { data ->
                val request = HciLineMatchServiceRequest(data.findOthersOnlyInput)
                val result = consumer.serviceRequest<HciLineMatchServiceResult>(request)
                result!!.lineL shouldHaveAtLeastSize 1
                result.lineL shouldNotHaveSingleElement nameMatches(result, data.findOthersOnlyInput)
            }
        }
    }
}) {

    sealed interface TestData : HciTestProfile.TestData {
        data class FindSelf(val findSelfInput: String) : TestData
        data class FindOthersOnly(val findOthersOnlyInput: String) : TestData
    }
}

fun nameMatches(result: HciLineMatchServiceResult, name: String): (HciLine) -> Boolean = matcher@{ line ->
    result.common!!.prodL[line.prodX ?: return@matcher false].name == name
}


