package de.jlnstrk.transit.client.efa.request.feature

import de.jlnstrk.transit.client.efa.request.EfaRequestMap
import de.jlnstrk.transit.client.efa.request.EfaRequestMapDelegate
import de.jlnstrk.transit.client.efa.request.delegate.EfaDateParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaMinutesParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaTimeParam
import de.jlnstrk.transit.client.efa.util.EFA_DATE_FORMAT_NO_SEP
import de.jlnstrk.transit.client.efa.util.EFA_TIME_FORMAT_COLON_SEP
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime

public interface EfaDateTimeRequest {
    public var itdDate: LocalDate?
    public var itdTime: LocalTime?
    public var timeOffset: Duration?

    public class MapDelegate internal constructor(
        override val queryMap: EfaRequestMap
    ) : EfaDateTimeRequest,
        EfaRequestMapDelegate {

        override var itdDate: LocalDate? by EfaDateParam(EFA_DATE_FORMAT_NO_SEP)
        override var itdTime: LocalTime? by EfaTimeParam(EFA_TIME_FORMAT_COLON_SEP)
        override var timeOffset: Duration? by EfaMinutesParam
    }
}