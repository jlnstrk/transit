package de.jlnstrk.transit.api.efa.endpoint.stopfinder

import de.jlnstrk.transit.api.efa.model.EfaPoint
import de.jlnstrk.transit.api.efa.request.EfaRequest
import de.jlnstrk.transit.api.efa.request.EfaRequestMap
import de.jlnstrk.transit.api.efa.request.feature.EfaMeansCheckboxRequest
import de.jlnstrk.transit.api.efa.request.feature.EfaPointVerificationRequest
import de.jlnstrk.transit.api.efa.response.EfaPointVerification

public class EfaStopFinderRequest(
    queryMap: EfaRequestMap = EfaRequestMap()
) : EfaRequest(queryMap),
    EfaPointVerificationRequest by EfaPointVerificationRequest.MapDelegate(queryMap),
    EfaMeansCheckboxRequest by EfaMeansCheckboxRequest.MapDelegate(queryMap) {

    public fun sf(point: EfaPoint, options: EfaPointVerificationRequest.UsageOptions.() -> Unit) {
        addPoint(EfaPointVerification.Usage.STOP_FINDER, point, options)
    }
}