package de.jlnstrk.transit.api.efa

import de.jlnstrk.transit.api.efa.endpoint.stt.EfaSttRequest
import de.jlnstrk.transit.api.efa.model.EfaPoint

suspend fun main() {

    val endpoint = EfaEndpoint.newClient("https://efa.mvv-muenchen.de/bcl/")
    val request = EfaSttRequest {
        stt(
            EfaPoint.Stop(
                name = "Alte Heide"
            )
        )
        line = setOf("mvv:23040:N:H:s21")
        modeDirect = true
    }
    val response = endpoint.xmlSttRequest(request)
}