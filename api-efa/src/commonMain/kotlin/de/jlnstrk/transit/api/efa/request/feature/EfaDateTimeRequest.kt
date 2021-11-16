package de.jlnstrk.transit.api.efa.request.feature

import com.soywiz.klock.format
import com.soywiz.klock.minutes
import com.soywiz.klock.parseDate
import com.soywiz.klock.parseTime
import de.jlnstrk.transit.api.efa.request.EfaRequestMap
import de.jlnstrk.transit.api.efa.request.EfaRequestMapDelegate
import de.jlnstrk.transit.api.efa.request.delegate.EfaQueryParam
import de.jlnstrk.transit.api.efa.util.EFA_DATE_FORMAT_NO_SEP
import de.jlnstrk.transit.api.efa.util.EFA_TIME_FORMAT_COLON_SEP
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlin.math.roundToInt

public interface EfaDateTimeRequest {
    public var itdDate: LocalDate?
    public var itdTime: LocalTime?
    public var timeOffset: Duration?

    public class MapDelegate internal constructor(
        override val queryMap: EfaRequestMap
    ) : EfaDateTimeRequest,
        EfaRequestMapDelegate {

        override var itdDate: LocalDate? by EfaQueryParam(
            serialize = { EFA_DATE_FORMAT_NO_SEP.format(it) },
            deserialize = { EFA_DATE_FORMAT_NO_SEP.parseDate(it) }
        )
        override var itdTime: LocalTime? by EfaQueryParam(
            serialize = { EFA_TIME_FORMAT_COLON_SEP.format(it) },
            deserialize = { EFA_TIME_FORMAT_COLON_SEP.parseTime(it) }
        )
        override var timeOffset: Duration? by EfaQueryParam(
            serialize = { it.minutes.roundToInt().toString() },
            deserialize = { it.toLong().minutes }
        )
    }
}