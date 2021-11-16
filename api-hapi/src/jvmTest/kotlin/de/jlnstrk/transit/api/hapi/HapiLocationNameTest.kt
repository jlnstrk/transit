package de.jlnstrk.transit.api.hapi

import de.jlnstrk.transit.api.hapi.base.HapiShouldSpec
import de.jlnstrk.transit.api.hapi.base.HapiTestProfile
import de.jlnstrk.transit.util.testing.givenAll
import de.jlnstrk.transit.api.hapi.model.location.HapiStopLocation
import de.jlnstrk.transit.api.hapi.request.HapiLocationNameRequest
import io.kotest.matchers.collections.shouldExist

internal class HapiLocationNameTest : HapiShouldSpec(HapiTestProfile[HapiService.LOCATION_NAME], { hapi, profile ->
    givenAll<DataSet.FindByName>(from = profile) { dataSet ->
        should("find ${dataSet.findExtId} for ${dataSet.input}") {
            val request = HapiLocationNameRequest {
                input = dataSet.input
            }
            val response = hapi.hapiRequest(request)
            response.stopLocationOrCoordLocation.shouldExist {
                it is HapiStopLocation
                        && it.extId == dataSet.findExtId
                        && it.name.contains(dataSet.findNameContains)
            }
        }
    }
}) {

    sealed interface DataSet : HapiTestProfile.DataSet {
        data class FindByName(
            val input: String,
            val findNameContains: String,
            val findExtId: String
        ) : DataSet
    }
}