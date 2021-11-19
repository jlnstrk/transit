package de.jlnstrk.transit.api.efa.request.feature

import de.jlnstrk.transit.api.efa.model.EfaPoint
import de.jlnstrk.transit.api.efa.request.EfaRequestDsl
import de.jlnstrk.transit.api.efa.request.EfaRequestMapDelegate
import de.jlnstrk.transit.api.efa.request.EfaRequestMap
import de.jlnstrk.transit.api.efa.request.convert.serialize
import de.jlnstrk.transit.api.efa.request.delegate.EfaBooleanParam
import de.jlnstrk.transit.api.efa.request.delegate.EfaIntParam
import de.jlnstrk.transit.api.efa.request.delegate.EfaQueryParam
import de.jlnstrk.transit.api.efa.request.delegate.EfaStringParam
import de.jlnstrk.transit.api.efa.response.EfaPointVerification

@EfaRequestDsl
public interface EfaPointVerificationRequest {
    public var stateless: Boolean?
    public var locationServerActive: Boolean?
    public var locationInfoActive: Boolean?
    public var useLocalityMainStop: Boolean?
    public var signalWhenPerfectNoOtherMatches: Boolean?
    public var anyMaxSizeHitList: Int?
    public var prMinQu: Int?

    public fun addPoint(
        usage: EfaPointVerification.Usage,
        point: EfaPoint,
        options: UsageOptions.() -> Unit
    )

    public class MapDelegate internal constructor(
        override val queryMap: EfaRequestMap
    ) : EfaPointVerificationRequest,
        EfaRequestMapDelegate {
        override var stateless: Boolean? by EfaBooleanParam
        override var locationServerActive: Boolean? by EfaBooleanParam
        override var locationInfoActive: Boolean? by EfaBooleanParam
        override var useLocalityMainStop: Boolean? by EfaBooleanParam
        override var signalWhenPerfectNoOtherMatches: Boolean? by EfaBooleanParam
        override var anyMaxSizeHitList: Int? by EfaIntParam
        override var prMinQu: Int? by EfaIntParam

        override fun addPoint(
            usage: EfaPointVerification.Usage,
            point: EfaPoint,
            options: UsageOptions.() -> Unit
        ) {
            var type = point.type
            val nameValue: String = when {
                point.ref?.id != null -> point.ref.id.toString()
                point.stateless != null -> point.stateless
                point.name == null && point.ref?.coords != null -> {
                    type = EfaPointVerification.Type.COORD
                    val (x, y, system) = point.ref.coords
                    "$x:$y:${system.serialize()}"
                }
                else -> point.name.orEmpty()
            }
            val usageSerial = usage.serialize()
            queryMap["name_$usageSerial"] = nameValue
            queryMap["type_$usageSerial"] = (type ?: EfaPointVerification.Type.ANY).serialize()

            UsageOptions.MapDelegate(queryMap, usage)
                .options()
        }
    }

    public interface UsageOptions {
        public var nameDefaultText: String?
        public var nameInfo: String?
        public var typeInfo: String?
        public var resultSort: String?
        public var omc: String?
        public var regionId: String?
        public var objectFilter: Set<EfaPoint.ObjectType>?
        public var useHouseNumberList: Boolean?
        public var deleteAssignedStops: Boolean?
        public var doNotSearchForStops: Boolean?

        public class MapDelegate internal constructor(
            override val queryMap: EfaRequestMap,
            usage: EfaPointVerification.Usage,
            usageSerial: String = usage.serialize()
        ) : UsageOptions, EfaRequestMapDelegate {

            override var nameDefaultText: String? by EfaStringParam.withKey("nameDefaultText_$usageSerial")
            override var nameInfo: String? by EfaStringParam.withKey("nameInfo_$usageSerial")
            override var typeInfo: String? by EfaStringParam.withKey("typeInfo_$usageSerial")
            override var resultSort: String? by EfaStringParam.withKey("resultSort_$usageSerial")
            override var omc: String? by EfaStringParam.withKey("anyOmc_$usageSerial")
            override var regionId: String? by EfaStringParam.withKey("regionID_$usageSerial")
            override var useHouseNumberList: Boolean? by EfaBooleanParam.withKey("useHouseNumberList_$usageSerial")
            override var deleteAssignedStops: Boolean? by EfaBooleanParam.withKey("deleteAssignedStops_$usageSerial")
            override var doNotSearchForStops: Boolean? by EfaBooleanParam.withKey("doNotSearchForStops_$usageSerial")
            override var objectFilter: Set<EfaPoint.ObjectType>? by EfaQueryParam(
                serialize = { it.sumOf { 1 shl it.ordinal }.toString() },
                deserialize = {
                    val values = EfaPoint.ObjectType.values()
                    it.withIndex()
                        .filter { it.value == '1' }
                        .map { values[it.index] }
                        .toSet()
                },
                key = "anyObjFilter_$usageSerial",
            )
        }
    }
}