package de.jlnstrk.transit.api.efa.request.feature

import com.soywiz.klock.format
import com.soywiz.klock.parseDate
import de.jlnstrk.transit.api.efa.request.EfaRequestMap
import de.jlnstrk.transit.api.efa.request.EfaRequestMapDelegate
import de.jlnstrk.transit.api.efa.request.delegate.EfaBooleanParam
import de.jlnstrk.transit.api.efa.request.delegate.EfaQueryParam
import de.jlnstrk.transit.api.efa.request.delegate.EfaStringMultiParam
import de.jlnstrk.transit.api.efa.request.delegate.EfaStringParam
import de.jlnstrk.transit.api.efa.util.EFA_DATE_FORMAT_NO_SEP
import de.jlnstrk.transit.util.LocalDate

public interface EfaLineVerificationRequest {
    public var line: Set<String>
    public var isShowTrainsExplicit: Boolean?
    public var lineVer: String?
    public var dateDay: LocalDate?

    public class MapDelegate(
        override val queryMap: EfaRequestMap
    ) : EfaRequestMapDelegate, EfaLineVerificationRequest {
        override var line: Set<String> by EfaStringMultiParam
        override var isShowTrainsExplicit: Boolean? by EfaBooleanParam
        override var lineVer: String? by EfaStringParam
        override var dateDay: LocalDate? by EfaQueryParam(
            serialize = { EFA_DATE_FORMAT_NO_SEP.format(it) },
            deserialize = { EFA_DATE_FORMAT_NO_SEP.parseDate(it) },
        )
    }
}