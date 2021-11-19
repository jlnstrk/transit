package de.jlnstrk.transit.api.hapi

import de.jlnstrk.transit.api.hapi.base.HapiShouldSpec
import de.jlnstrk.transit.api.hapi.base.HapiTestProfile
import de.jlnstrk.transit.util.testing.givenAll
import de.jlnstrk.transit.api.hapi.model.location.HapiStopLocation
import de.jlnstrk.transit.api.hapi.request.HapiLocationNearbyStopsRequest
import io.kotest.matchers.collections.shouldExist

internal class HapiLocationNearbyStopsTest : HapiShouldSpec(HapiTestProfile[HapiEndpoint.LOCATION_NEARBYSTOPS], { hapi, profile ->
    givenAll<DataSet.FindNearby>(from = profile) { dataSet ->
        should("find ${dataSet.findExtId} near (${dataSet.originLat}, ${dataSet.originLong})") {
            val request = HapiLocationNearbyStopsRequest {
                originCoordLat = dataSet.originLat
                originCoordLong = dataSet.originLong
            }
            val response = hapi.hapiRequest(request)
            response.stopLocationOrCoordLocation.shouldExist {
                it is HapiStopLocation
                        && (it.extId == dataSet.findExtId || it.mainMastExtId == dataSet.findExtId)
                        && it.name.contains(dataSet.findNameContains)
            }
        }
    }
}) {

    sealed interface DataSet : HapiTestProfile.DataSet {
        data class FindNearby(
            val originLat: Double,
            val originLong: Double,
            val findNameContains: String,
            val findExtId: String
        ) : DataSet
    }
}