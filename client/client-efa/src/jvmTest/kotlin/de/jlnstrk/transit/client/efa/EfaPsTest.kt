package de.jlnstrk.transit.client.efa

import de.jlnstrk.transit.client.efa.endpoint.ps.EfaPsRequest
import de.jlnstrk.transit.client.efa.model.EfaPoint
import de.jlnstrk.transit.client.efa.request.EfaDateTimeMode
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration.Companion.hours

suspend fun main() {

    val client = EfaClient {
        baseUrl = "https://efa.mvv-muenchen.de/mobile/"
    }
    val request = EfaPsRequest {
        origin(
            EfaPoint.Stop(
                name = "Getrud-Grunow-Straße"
            )
        )
        destination(
            EfaPoint.Stop(
                name = "Garching Forschungszentrum"
            )
        )

        itdDateTimeDepArr = EfaDateTimeMode.DEPARTURE
        psParamSampleDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
        psParamOneWay = false
        psParamMaxTimeHours = 6.hours
    }
    val response = client.xmlPsRequest(request)
}