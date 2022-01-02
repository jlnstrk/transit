package de.jlnstrk.transit.client.hci

import de.jlnstrk.transit.client.hci.base.HciShouldSpec
import de.jlnstrk.transit.client.hci.base.HciTestProfile
import de.jlnstrk.transit.client.hci.method.locmatch.HciLocMatchServiceRequest
import de.jlnstrk.transit.client.hci.method.locmatch.HciLocMatchServiceResult
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.model.location.HciLocationField
import de.jlnstrk.transit.client.hci.model.location.HciLocationInput
import de.jlnstrk.transit.client.hci.model.location.HciLocationType
import de.jlnstrk.transit.util.testing.givenAll
import io.kotest.matchers.collections.shouldHaveSingleElement
import io.kotest.matchers.shouldBe

internal class LocMatchTest : HciShouldSpec(HciTestProfile.ALL_PROFILES, { hci, profile ->
    givenAll<TestData.StationNameMatch>(from = profile) { dataSet ->
        should("match extId ${dataSet.findExtId} for name ${dataSet.matchName}") {
            val request = HciLocMatchServiceRequest {
                input = HciLocationInput(
                    field = HciLocationField.S,
                    loc = HciLocation(
                        type = HciLocationType.S,
                        name = dataSet.matchName,
                    ),
                )
            }
            val result = hci.serviceRequest<HciLocMatchServiceResult>(request)!!
            result.match.field shouldBe HciLocationField.S
            result.match.locL.shouldHaveSingleElement { it.type == HciLocationType.S && it.extId == dataSet.findExtId }
        }
    }
    givenAll<TestData.StationIdMatch>(from = profile) { dataSet ->
        should("match name ${dataSet.findNameContains} on extId ${dataSet.matchExtId}") {
            val request = HciLocMatchServiceRequest {
                input = HciLocationInput(
                    field = HciLocationField.S,
                    loc = HciLocation(
                        type = HciLocationType.S,
                        extId = dataSet.matchExtId
                    )
                )
            }
            val result = hci.serviceRequest<HciLocMatchServiceResult>(request)!!
            result.match.field shouldBe HciLocationField.S
            result.match.locL.shouldHaveSingleElement {
                it.type == HciLocationType.S && it.name?.contains(dataSet.findNameContains) == true
            }
        }
    }
}) {

    sealed interface TestData : HciTestProfile.TestData {
        data class StationNameMatch(val matchName: String, val findExtId: String) : TestData
        data class StationIdMatch(val matchExtId: String, val findNameContains: String) : TestData
    }
}