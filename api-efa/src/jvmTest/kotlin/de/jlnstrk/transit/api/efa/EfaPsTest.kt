package de.jlnstrk.transit.api.efa

import com.soywiz.klock.hours
import de.jlnstrk.transit.api.efa.endpoint.ps.EfaPsRequest
import de.jlnstrk.transit.api.efa.model.EfaPoint
import de.jlnstrk.transit.api.efa.request.EfaDateTimeMode
import de.jlnstrk.transit.util.LocalDateTime

suspend fun main() {

    val endpoint = EfaClient("https://efa.mvv-muenchen.de/mobile/")
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
        psParamSampleDate = LocalDateTime.now().date
        psParamOneWay = false
        psParamMaxTimeHours = 6.hours
    }
    val response = endpoint.xmlPsRequest(request)
}