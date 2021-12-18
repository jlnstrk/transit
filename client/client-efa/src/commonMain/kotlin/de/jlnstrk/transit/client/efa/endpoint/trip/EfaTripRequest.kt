package de.jlnstrk.transit.client.efa.endpoint.trip

import de.jlnstrk.transit.client.efa.model.EfaPoint
import de.jlnstrk.transit.client.efa.request.EfaDateTimeMode
import de.jlnstrk.transit.client.efa.request.EfaRequest
import de.jlnstrk.transit.client.efa.request.EfaRequestMap
import de.jlnstrk.transit.client.efa.request.EfaRequestMapDelegate
import de.jlnstrk.transit.client.efa.request.delegate.*
import de.jlnstrk.transit.client.efa.request.feature.EfaDateTimeRequest
import de.jlnstrk.transit.client.efa.request.feature.EfaMeansCheckboxRequest
import de.jlnstrk.transit.client.efa.request.feature.EfaPointVerificationRequest
import de.jlnstrk.transit.client.efa.response.EfaPointVerification
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

public class EfaTripRequest(
    queryMap: EfaRequestMap = EfaRequestMap()
) : EfaRequest(queryMap),
    EfaPointVerificationRequest by EfaPointVerificationRequest.MapDelegate(queryMap),
    EfaDateTimeRequest by EfaDateTimeRequest.MapDelegate(queryMap),
    EfaMeansCheckboxRequest by EfaMeansCheckboxRequest.MapDelegate(queryMap) {
    public var calcNumberOfTrips: Int? by EfaIntParam
    public var calcOneDirection: Boolean? by EfaBooleanParam
    public var useRealtime: Boolean? by EfaBooleanParam
    public var itdTripDateTimeDepArr: EfaDateTimeMode? by EfaEnumParam()

    public var impairedOptionsActive: Boolean? by EfaQueryFlag
    public var lowPlatformVhcl: Boolean? by EfaQueryFlag
    public var noElevators: Boolean? by EfaQueryFlag
    public var noEscalators: Boolean? by EfaQueryFlag
    public var noSolidStairs: Boolean? by EfaQueryFlag
    public var wheelchair: Boolean? by EfaQueryFlag
    public var command: Command? by EfaEnumParam()

    public var ptOptionsActive: Boolean? by EfaBooleanParam
    public var itOptionsActive: Boolean? by EfaBooleanParam

    public fun origin(point: EfaPoint, options: EfaPointVerificationRequest.UsageOptions.() -> Unit = {}) {
        addPoint(EfaPointVerification.Usage.ORIGIN, point, options)
    }

    public fun destination(point: EfaPoint, options: EfaPointVerificationRequest.UsageOptions.() -> Unit = {}) {
        addPoint(EfaPointVerification.Usage.DESTINATION, point, options)
    }

    public fun via(point: EfaPoint, options: EfaPointVerificationRequest.UsageOptions.() -> Unit = {}) {
        addPoint(EfaPointVerification.Usage.VIA, point, options)
    }

    public fun publicTransportOptions(options: PtOptions.() -> Unit) {
        ptOptionsActive = true
        PtOptions(queryMap).also(options)
    }

    public fun individualTransportOptions(options: ItOptions.() -> Unit) {
        itOptionsActive = true
        ItOptions(queryMap).also(options)
    }

    @Serializable
    public enum class Command {
        @SerialName("nop")
        NOP,

        @SerialName("changeRequest")
        CHANGE_REQUEST,

        @SerialName("tripRetoure")
        TRIP_RETOURE,

        @SerialName("tripGoOn")
        TRIP_GO_ON,

        @SerialName("tripPrev")
        TRIP_PREV,

        @SerialName("tripNext")
        TRIP_NEXT,

        @SerialName("tripLast")
        TRIP_LAST,

        @SerialName("tripFirst")
        TRIP_FIRST,

        @SerialName("printOverview")
        PRINT_OVERVIEW
        // class PrintSingleView(val index: Int) : Command("printSingleView:$index")
    }

    public class PtOptions internal constructor(
        override val queryMap: EfaRequestMap
    ) : EfaRequestMapDelegate {
        public var changeSpeed: ChangeSpeed? by EfaEnumParam()
        public var lineRestriction: LineRestriction? by EfaEnumParam()
        public var maxChanges: Int? by EfaIntParam
        public var routeType: RouteType? by EfaEnumParam()
        public var useProxFootSearch: Boolean? by EfaBooleanParam
        public var useProxFootSearchOrig: Boolean? by EfaBooleanParam
        public var useProxFootSearchDest: Boolean? by EfaBooleanParam

        @Serializable
        public enum class RouteType {
            @SerialName("LEASTTIME")
            LEAST_TIME,

            @SerialName("LEASTINTERCHANGE")
            LEAST_CHANGES,

            @SerialName("FASTEST")
            FASTEST,

            @SerialName("LEASTWALKING")
            LEAST_WALKING
        }

        @Serializable
        public enum class LineRestriction {
            @SerialName("400")
            ALL,

            @SerialName("401")
            ALL_EXCEPT_ICE,

            @SerialName("402")
            NETWORK_NO_SURCHARGE,

            @SerialName("403")
            NETWORK_AND_LOCAL
        }
    }

    public class ItOptions internal constructor(
        override val queryMap: EfaRequestMap
    ) : EfaRequestMapDelegate {
        public var changeSpeed: ChangeSpeed? by EfaEnumParam()
        public var trlTMOT: Set<Means> by EfaEnumMultiParam()
        public var trlTDepMOT: Set<Means> by EfaEnumMultiParam()
        public var trlTArrMOT: Set<Means> by EfaEnumMultiParam()
        public var trlTMOTvalue: Duration? by EfaMinutesParam
        public var trlTDepMOTvalue: Duration? by EfaMinutesParam
        public var trlTArrMOTvalue: Duration? by EfaMinutesParam

        @Serializable
        public enum class Means {
            @SerialName("100")
            FOOTWAY,

            @SerialName("101")
            BIKE_AND_RIDE,

            @SerialName("102")
            BICYCLE_CARRIAGE,

            @SerialName("103")
            KISS_AND_RIDE,

            @SerialName("104")
            PARK_AND_RIDE,

            @SerialName("105")
            TAXI,
        }
    }

    @Serializable
    public enum class ChangeSpeed {
        SLOW,
        NORMAL,
        FAST,
    }
}