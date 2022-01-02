@file:OptIn(ExperimentalKotest::class, ExperimentalCoroutinesApi::class)

package de.jlnstrk.transit.client.hci

import de.jlnstrk.transit.client.hci.method.locsearch.HciLocSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.locsearch.HciLocSearchServiceResult
import de.jlnstrk.transit.client.hci.model.location.HciLocationType
import de.jlnstrk.transit.util.testing.forEachGiven
import io.kotest.common.ExperimentalKotest
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldHaveSingleElement
import jdk.nashorn.internal.objects.NativeJava.type
import kotlinx.coroutines.ExperimentalCoroutinesApi

internal class LocSearchTest : ShouldSpec({
    should("find searched locations") {
        forEachGiven<LocMatchTest.TestData.StationNameMatch> { profile, consumer, data ->
            val request = HciLocSearchServiceRequest {
                query = data.matchName
            }
            val result = consumer.serviceRequest<HciLocSearchServiceResult>(request)!!
            result.locL.shouldHaveSingleElement {
                it.type == HciLocationType.S && it.extId == data.findExtId
            }
        }
    }
})

/*internal class LocSearchTest : HciShouldSpec(HciTestProfile.ALL_PROFILES, { hci, profile ->
    givenAll<LocMatchTest.DataSet.StationNameMatch>(from = profile) { dataSet ->
        should("find extId ${dataSet.findExtId} for name ${dataSet.matchName}") {
            val request = HciLocSearchServiceRequest {
                query = dataSet.matchName
            }
            val result = hci.serviceRequest<HciLocSearchServiceResult>(request)!!
            result.locL.shouldHaveSingleElement {
                it.type == HciLocationType.S && it.extId == dataSet.findExtId
            }
        }
    }
})*/