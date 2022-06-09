package de.jlnstrk.transit.client.efa.util

import com.soywiz.klock.DateFormat
import com.soywiz.klock.TimeFormat

internal val EFA_DATE_FORMAT_NO_SEP = DateFormat("yyyyMMdd")
internal val EFA_DATE_FORMAT_DOT_SEP = DateFormat("dd.MM.yyyy")
internal val EFA_DATE_FORMAT_DASH_SEP = DateFormat("dd-MM-yyyy")
internal val EFA_TIME_FORMAT_NO_SEP = TimeFormat("HHmm")
internal val EFA_TIME_SECONDS_FORMAT_NO_SEP = TimeFormat("HHmmss")
internal val EFA_TIME_FORMAT_COLON_SEP = TimeFormat("HH:mm")
internal val EFA_TIME_SECONDS_FORMAT_COLON_SEP = TimeFormat("HH:mm:ss")
internal val EFA_DATETIME_FORMAT_SPACE_SEP = DateFormat("yyyyMMdd HH:mm[:ss]")
    .withOptional()
