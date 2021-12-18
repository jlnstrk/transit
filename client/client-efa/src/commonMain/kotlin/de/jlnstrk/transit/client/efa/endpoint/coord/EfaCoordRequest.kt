package de.jlnstrk.transit.client.efa.endpoint.coord

import de.jlnstrk.transit.client.efa.model.EfaCoordinates
import de.jlnstrk.transit.client.efa.model.EfaPin
import de.jlnstrk.transit.client.efa.request.EfaRequest
import de.jlnstrk.transit.client.efa.request.EfaRequestMap
import de.jlnstrk.transit.client.efa.request.EfaRequestMapDelegate
import de.jlnstrk.transit.client.efa.request.delegate.EfaBooleanParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaEnumParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaIntParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaQueryParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaStringParam
import de.jlnstrk.transit.client.efa.request.feature.EfaMeansCheckboxRequest
import de.jlnstrk.transit.client.efa.util.formatQueryCoordinates
import de.jlnstrk.transit.client.efa.util.parseQueryCoordinates

public class EfaCoordRequest(
    queryMap: EfaRequestMap = EfaRequestMap()
) : EfaRequest(queryMap),
    EfaMeansCheckboxRequest by EfaMeansCheckboxRequest.MapDelegate(queryMap) {
    private var filterIndex: Int = 0
    public var inclFilter: Boolean? by EfaBooleanParam
    public var max: Int? by EfaIntParam
    public var coord: EfaCoordinates? by EfaQueryParam(
        serialize = EfaCoordinates::formatQueryCoordinates,
        deserialize = String::parseQueryCoordinates
    )

    public fun addFilter(options: FilterOptions.() -> Unit) {
        FilterOptions(queryMap, ++filterIndex)
            .also(options)
    }

    public class FilterOptions internal constructor(
        override val queryMap: EfaRequestMap,
        filterIndex: Int
    ) : EfaRequestMapDelegate {
        public var type: EfaPin.Type? by EfaEnumParam("type_$filterIndex")
        public var radius: Int? by EfaIntParam
        public var inclDrawClasses: Boolean? by EfaBooleanParam.withKey("inclDrawClasses_$filterIndex")
        public var inclPOIH: Boolean? by EfaBooleanParam.withKey("inclPOIH_$filterIndex")
        public var exclLayers: String? by EfaStringParam.withKey("exclLayers_$filterIndex")
    }
}