package de.jlnstrk.transit.api.efa.util

import com.soywiz.klock.DateFormat
import com.soywiz.klock.TimeFormat

internal val EFA_DATE_FORMAT_NO_SEP = DateFormat("yyyyMMdd")
internal val EFA_DATE_FORMAT_DOT_SEP = DateFormat("dd.MM.yyyy")
internal val EFA_DATE_FORMAT_DASH_SEP = DateFormat("dd-MM-yyyy")
internal val EFA_TIME_FORMAT_NO_SEP = TimeFormat("HHmm[ss]")
    .withOptional()
internal val EFA_TIME_FORMAT_COLON_SEP = TimeFormat("HH:mm[:ss]")
    .withOptional()
internal val EFA_DATETIME_FORMAT_SPACE_SEP = DateFormat("yyyyMMdd HH:mm[:ss]")
    .withOptional()
