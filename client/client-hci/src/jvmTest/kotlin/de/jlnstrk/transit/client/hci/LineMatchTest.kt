package de.jlnstrk.transit.client.hci

import de.jlnstrk.transit.client.hci.base.*
import de.jlnstrk.transit.client.hci.base.HciShouldSpec
import de.jlnstrk.transit.client.hci.method.linematch.HciLineMatchRequest
import de.jlnstrk.transit.client.hci.model.HciLine
import de.jlnstrk.transit.client.hci.response.HciServiceResult
import de.jlnstrk.transit.util.testing.givenAll
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.collections.shouldHaveSingleElement
import io.kotest.matchers.collections.shouldNotHaveSingleElement

internal class LineMatchTest : HciShouldSpec(HciTestProfile.ALL_PROFILES, { hci, profile ->
    givenAll<DataSet>(from = profile) { dataSet ->
        should("match ${dataSet.findSelfInput} and others on ${dataSet.findSelfInput}") {
            val request = HciLineMatchRequest(dataSet.findSelfInput)
            val result = hci.serviceRequest(request)
            result!!.lineL shouldHaveSingleElement nameMatches(result, dataSet.findSelfInput)
        }

        should("match only others on ${dataSet.findOthersOnlyInput}") {
            val request = HciLineMatchRequest(dataSet.findOthersOnlyInput)
            val result = hci.serviceRequest(request)
            result!!.lineL shouldHaveAtLeastSize 1
            result.lineL shouldNotHaveSingleElement nameMatches(result, dataSet.findOthersOnlyInput)
        }
    }
}) {

    data class DataSet(
        val findSelfInput: String,
        val findOthersOnlyInput: String
    ) : HciTestProfile.DataSet
}

fun nameMatches(result: HciServiceResult, name: String): (HciLine) -> Boolean = matcher@ { line ->
    result.common.prodL[line.prodX ?: return@matcher false].name == name
}


