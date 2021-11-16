package de.jlnstrk.transit.api.hci

import de.jlnstrk.transit.api.hci.base.HciShouldSpec
import de.jlnstrk.transit.api.hci.base.HciTestProfile
import de.jlnstrk.transit.api.hci.method.locmatch.HciLocMatchRequest
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.model.location.HciLocationField
import de.jlnstrk.transit.api.hci.model.location.HciLocationInput
import de.jlnstrk.transit.util.testing.givenAll
import io.kotest.matchers.collections.shouldHaveSingleElement
import io.kotest.matchers.shouldBe

internal class LocMatchTest : HciShouldSpec(HciTestProfile.ALL_PROFILES, { hci, profile ->
    givenAll<DataSet.StationNameMatch>(from = profile) { dataSet ->
        should("match extId ${dataSet.findExtId} for name ${dataSet.matchName}") {
            val input = HciLocationInput(
                field = HciLocationField.S,
                loc = HciLocation(
                    type = HciLocation.Type.STATION,
                    name = dataSet.matchName,
                ),
            )
            val request = HciLocMatchRequest(input)
            val result = hci.serviceRequest(request)!!
            result.match.field shouldBe HciLocationField.S
            result.match.locL.shouldHaveSingleElement { it.type == HciLocation.Type.STATION && it.extId == dataSet.findExtId }
        }
    }
    givenAll<DataSet.StationIdMatch>(from = profile) { dataSet ->
        should("match name ${dataSet.findNameContains} on extId ${dataSet.matchExtId}") {
            val input = HciLocationInput(
                field = HciLocationField.S,
                loc = HciLocation(
                    type = HciLocation.Type.STATION,
                    extId = dataSet.matchExtId
                )
            )
            val request = HciLocMatchRequest(input)
            val result = hci.serviceRequest(request)!!
            result.match.field shouldBe HciLocationField.S
            result.match.locL.shouldHaveSingleElement {
                it.type == HciLocation.Type.STATION && it.name?.contains(dataSet.findNameContains) == true
            }
        }
    }
}) {

    sealed interface DataSet : HciTestProfile.DataSet {
        data class StationNameMatch(val matchName: String, val findExtId: Long) : DataSet
        data class StationIdMatch(val matchExtId: Long, val findNameContains: String) : DataSet
    }
}