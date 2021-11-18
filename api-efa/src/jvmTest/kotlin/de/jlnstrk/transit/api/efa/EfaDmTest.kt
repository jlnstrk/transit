package de.jlnstrk.transit.api.efa

import de.jlnstrk.transit.api.efa.endpoint.dm.EfaDmRequest
import de.jlnstrk.transit.api.efa.model.EfaCoordinateSystem
import de.jlnstrk.transit.api.efa.model.EfaCoordinates
import de.jlnstrk.transit.api.efa.model.EfaPoint
import de.jlnstrk.transit.api.efa.model.EfaReference
import de.jlnstrk.transit.api.efa.request.EfaDateTimeMode
import de.jlnstrk.transit.api.efa.response.EfaPointVerification
import io.kotest.core.spec.style.ShouldSpec

class EfaDmTest : ShouldSpec({
    should("do whatever") {
        val client = EfaClient {
            baseUrl = "https://efa.mvv-muenchen.de/bcl/"
        }
        val request = EfaDmRequest {
            dm(EfaPoint.Any(
                type = EfaPointVerification.Type.COORD,
                ref = EfaReference(
                    coords = EfaCoordinates(
                        x = 11.5967824,
                        y = 48.1835557,
                        mapName = EfaCoordinateSystem.WGS84_DECIMAL
                    )
                )
            ))

            modeDirect = true
            depType = EfaDmRequest.DepartureType.STOP_EVENTS
            includeCompleteStopSeq = true
            stateless = true
            useRealtime = true
            itdDateTimeDepArr = EfaDateTimeMode.DEPARTURE
        }
        val res = client.xmlDmRequest(request)
        res
    }
})