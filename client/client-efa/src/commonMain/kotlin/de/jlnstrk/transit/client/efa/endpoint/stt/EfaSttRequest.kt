package de.jlnstrk.transit.client.efa.endpoint.stt

import de.jlnstrk.transit.client.efa.model.EfaPoint
import de.jlnstrk.transit.client.efa.request.EfaRequest
import de.jlnstrk.transit.client.efa.request.EfaRequestDsl
import de.jlnstrk.transit.client.efa.request.EfaRequestMap
import de.jlnstrk.transit.client.efa.request.delegate.EfaBooleanParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaQueryParam
import de.jlnstrk.transit.client.efa.request.feature.EfaLineVerificationRequest
import de.jlnstrk.transit.client.efa.request.feature.EfaPointVerificationRequest
import de.jlnstrk.transit.client.efa.response.EfaPointVerification

@EfaRequestDsl
public class EfaSttRequest(
    queryMap: EfaRequestMap = EfaRequestMap()
) : EfaRequest(queryMap),
    EfaPointVerificationRequest by EfaPointVerificationRequest.MapDelegate(queryMap),
    EfaLineVerificationRequest by EfaLineVerificationRequest.MapDelegate(queryMap) {
    public var mrgSt: Boolean? by EfaBooleanParam
    public var modeDirect: Boolean? by EfaQueryParam(
        serialize = { if (it) "direct" else "" },
        deserialize = { it == "direct" },
        key = "mode",
    )

    public fun stt(point: EfaPoint, options: EfaPointVerificationRequest.UsageOptions.() -> Unit = {}) {
        addPoint(EfaPointVerification.Usage.STOP_TIMETABLE, point, options)
    }

    public companion object {
        public operator fun invoke(init: EfaSttRequest.() -> Unit): EfaSttRequest =
            EfaSttRequest().apply(init)
    }
}