package de.jlnstrk.transit.client.efa.endpoint.stopfinder

import de.jlnstrk.transit.client.efa.model.EfaPoint
import de.jlnstrk.transit.client.efa.request.EfaRequest
import de.jlnstrk.transit.client.efa.request.EfaRequestMap
import de.jlnstrk.transit.client.efa.request.feature.EfaMeansCheckboxRequest
import de.jlnstrk.transit.client.efa.request.feature.EfaPointVerificationRequest
import de.jlnstrk.transit.client.efa.response.EfaPointVerification

public class EfaStopFinderRequest(
    queryMap: EfaRequestMap = EfaRequestMap()
) : EfaRequest(queryMap),
    EfaPointVerificationRequest by EfaPointVerificationRequest.MapDelegate(queryMap),
    EfaMeansCheckboxRequest by EfaMeansCheckboxRequest.MapDelegate(queryMap) {

    public fun sf(point: EfaPoint, options: EfaPointVerificationRequest.UsageOptions.() -> Unit) {
        addPoint(EfaPointVerification.Usage.STOP_FINDER, point, options)
    }
}