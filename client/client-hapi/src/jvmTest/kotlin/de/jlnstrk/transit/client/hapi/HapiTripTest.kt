package de.jlnstrk.transit.client.hapi

import de.jlnstrk.transit.client.hapi.base.HapiShouldSpec
import de.jlnstrk.transit.client.hapi.base.HapiTestProfile
import de.jlnstrk.transit.util.testing.givenAll
import de.jlnstrk.transit.client.hapi.request.HapiTripRequest
import io.kotest.matchers.collections.shouldExist
import io.kotest.matchers.collections.shouldHaveAtLeastSize

internal class HapiTripTest : HapiShouldSpec(HapiTestProfile[HapiEndpoint.TRIP], { hapi, profile ->
    givenAll<DataSet.FindTripById>(from = profile) { dataSet ->
        should("find trips from ${dataSet.originExtId} to ${dataSet.destExtId}") {
            val request = HapiTripRequest {
                originId = dataSet.originExtId
                destId = dataSet.destExtId
            }
            val response = hapi.hapiRequest(request)
            response.Trip shouldHaveAtLeastSize 1
            response.Trip shouldExist {
                val originExtId = it.Origin?.extId ?: it.LegList.first().Origin.extId
                val originMastExtId = it.Origin?.mainMastExtId ?: it.LegList.first().Origin.mainMastExtId
                val destExtId = it.Destination?.extId ?: it.LegList.last().Destination.extId
                val destMastExtId = it.Destination?.mainMastExtId ?: it.LegList.last().Destination.mainMastExtId
                (originExtId == dataSet.originExtId || originMastExtId == dataSet.originExtId)
                        && (destExtId == dataSet.destExtId || destMastExtId == dataSet.destExtId)
            }
        }
    }
}) {

    sealed interface DataSet : HapiTestProfile.DataSet {
        data class FindTripById(
            val originExtId: String,
            val destExtId: String,
        ) : DataSet
        data class FindTripByCoord(
            val originLat: Double,
            val originLong: Double,
            val destLat: Double,
            val destLong: Double
        ) : DataSet
        data class FindViaTrip(
            val originExtId: String,
            val viaExtId: String,
            val destExtId: String
        ) : DataSet
    }
}