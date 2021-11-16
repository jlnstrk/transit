package de.jlnstrk.transit.api.efa.endpoint.ps

import com.soywiz.klock.format
import com.soywiz.klock.hours
import com.soywiz.klock.parseDate
import com.soywiz.klock.parseTime
import de.jlnstrk.transit.api.efa.model.EfaPoint
import de.jlnstrk.transit.api.efa.request.EfaRequest
import de.jlnstrk.transit.api.efa.request.EfaRequestDsl
import de.jlnstrk.transit.api.efa.request.EfaRequestMap
import de.jlnstrk.transit.api.efa.request.EfaRequestMapDelegate
import de.jlnstrk.transit.api.efa.request.convert.serialize
import de.jlnstrk.transit.api.efa.request.delegate.*
import de.jlnstrk.transit.api.efa.request.feature.EfaPointVerificationRequest
import de.jlnstrk.transit.api.efa.response.EfaPointVerification
import de.jlnstrk.transit.api.efa.util.EFA_DATE_FORMAT_NO_SEP
import de.jlnstrk.transit.api.efa.util.EFA_TIME_FORMAT_COLON_SEP
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@EfaRequestDsl
public class EfaPsRequest(
    queryMap: EfaRequestMap = EfaRequestMap()
) : EfaRequest(queryMap), EfaPointVerificationRequest by EfaPointVerificationRequest.MapDelegate(queryMap) {
    public var itdDateTimeDepArr: DateTimeMode? by EfaEnumParam()
    public var psParamOneWay: Boolean? by EfaBooleanParam
    public var useAltOdv: Boolean? by EfaBooleanParam
    public var psParamGroupID: String? by EfaStringParam
    public var psParamMaxTimeHours: Duration? by EfaQueryParam(
        serialize = { it.hours.toInt().toString() },
        deserialize = { it.toInt().hours },
    )
    public var psParamSampleDate: LocalDate? by EfaQueryParam(
        serialize = { EFA_DATE_FORMAT_NO_SEP.format(it) },
        deserialize = { EFA_DATE_FORMAT_NO_SEP.parseDate(it) },
    )
    public var psParamWeekday: Weekday? by EfaEnumParam()
    public var useAllSampleDates: Boolean? by EfaBooleanParam

    public fun origin(point: EfaPoint, options: EfaPointVerificationRequest.UsageOptions.() -> Unit = {}) {
        addPoint(EfaPointVerification.Usage.ORIGIN, point, options)
    }

    public fun destination(point: EfaPoint, options: EfaPointVerificationRequest.UsageOptions.() -> Unit = {}) {
        addPoint(EfaPointVerification.Usage.DESTINATION, point, options)
    }

    public fun via(point: EfaPoint, options: EfaPointVerificationRequest.UsageOptions.() -> Unit = {}) {
        addPoint(EfaPointVerification.Usage.VIA, point, options)
    }

    public fun arrFrom(init: DateTimeOptions.() -> Unit) {
        DateTimeOptions(Usage.ARR_FROM).init()
    }

    public fun arrTo(init: DateTimeOptions.() -> Unit) {
        DateTimeOptions(Usage.ARR_TO).init()
    }

    public fun depFrom(init: DateTimeOptions.() -> Unit) {
        DateTimeOptions(Usage.DEP_FROM).init()
    }

    public fun depTo(init: DateTimeOptions.() -> Unit) {
        DateTimeOptions(Usage.DEP_TO).init()
    }

    @Serializable
    public enum class Weekday {
        @SerialName("6:SAMSTAG")
        SATURDAY,

        @SerialName("8:MO-FR")
        MONDAY_TO_FRIDAY,

        @SerialName("10:SONNTAG")
        SUNDAY,
    }

    @Serializable
    public enum class Usage {
        @SerialName("arrFrom")
        ARR_FROM,

        @SerialName("arrTo")
        ARR_TO,

        @SerialName("depFrom")
        DEP_FROM,

        @SerialName("depTo")
        DEP_TO,
    }

    @EfaRequestDsl
    public inner class DateTimeOptions(
        usage: Usage,
    ) : EfaRequestMapDelegate.Nested(this) {
        public var itdTime: LocalTime? by EfaQueryParam(
            serialize = { EFA_TIME_FORMAT_COLON_SEP.format(it) },
            deserialize = { EFA_TIME_FORMAT_COLON_SEP.parseTime(it) },
            key = "itdTime_${usage.serialize()}"
        )
        public var itdTimeAMPM: AmPmMode? by EfaEnumParam("itdTimeAMPM_${usage.serialize()}")
        public var itdTimeHour: Int? by EfaIntParam.withKey("itdTimeHour_${usage.serialize()}")
        public var itdTimeMinute: Int? by EfaIntParam.withKey("itdTimeMinute_${usage.serialize()}")
    }

    public companion object {
        public inline operator fun invoke(init: EfaPsRequest.() -> Unit): EfaPsRequest =
            EfaPsRequest().apply(init)
    }
}