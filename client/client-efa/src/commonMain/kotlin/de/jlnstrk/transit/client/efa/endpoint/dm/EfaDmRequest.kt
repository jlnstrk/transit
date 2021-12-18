package de.jlnstrk.transit.client.efa.endpoint.dm

import de.jlnstrk.transit.client.efa.model.EfaPoint
import de.jlnstrk.transit.client.efa.request.EfaDateTimeMode
import de.jlnstrk.transit.client.efa.request.EfaRequest
import de.jlnstrk.transit.client.efa.request.EfaRequestMap
import de.jlnstrk.transit.client.efa.request.delegate.EfaBooleanParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaEnumParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaIntParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaQueryParam
import de.jlnstrk.transit.client.efa.request.feature.EfaDateTimeRequest
import de.jlnstrk.transit.client.efa.request.feature.EfaLineVerificationRequest
import de.jlnstrk.transit.client.efa.request.feature.EfaMeansCheckboxRequest
import de.jlnstrk.transit.client.efa.request.feature.EfaPointVerificationRequest
import de.jlnstrk.transit.client.efa.response.EfaPointVerification
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

public class EfaDmRequest(
    queryMap: EfaRequestMap = EfaRequestMap()
) : EfaRequest(queryMap),
    EfaPointVerificationRequest by EfaPointVerificationRequest.MapDelegate(queryMap),
    EfaLineVerificationRequest by EfaLineVerificationRequest.MapDelegate(queryMap),
    EfaDateTimeRequest by EfaDateTimeRequest.MapDelegate(queryMap),
    EfaMeansCheckboxRequest by EfaMeansCheckboxRequest.MapDelegate(queryMap) {
    public var useRealtime: Boolean? by EfaBooleanParam
    public var includeCompleteStopSeq: Boolean? by EfaBooleanParam
    public var limit: Int? by EfaIntParam
    public var modeDirect: Boolean? by EfaQueryParam(
        serialize = { if (it) "direct" else "" },
        deserialize = { it == "direct" },
        key = "mode",
    )
    public var depType: DepartureType? by EfaEnumParam()
    public var itdDateTimeDepArr: EfaDateTimeMode? by EfaEnumParam()

    public fun dm(point: EfaPoint, options: EfaPointVerificationRequest.UsageOptions.() -> Unit = {}) {
        addPoint(EfaPointVerification.Usage.DEPARTURE_MONITOR, point, options)
    }

    @Serializable
    public enum class DepartureType {
        @SerialName("stopEvents")
        STOP_EVENTS,
    }

    public companion object {
        public operator fun invoke(init: EfaDmRequest.() -> Unit): EfaDmRequest =
            EfaDmRequest().apply(init)
    }
}