package de.jlnstrk.transit.sample.js

import com.soywiz.klock.TimeFormat
import de.jlnstrk.transit.common.extensions.require
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.stop.BaseDeparture
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.StationBoardService
import de.jlnstrk.transit.sample.SAMPLE_COORDINATES
import de.jlnstrk.transit.sample.SampleProvider
import kotlinx.browser.document
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.html.dom.append
import kotlinx.html.js.div
import kotlinx.html.js.h1
import kotlinx.html.li
import kotlinx.html.p
import kotlinx.html.ul

val TIME_FORMAT = TimeFormat("HH:mm")

fun BaseDeparture.formatTime(): String = TIME_FORMAT.format((departureRealtime ?: departureScheduled).local.time)

fun main() {
    document.body?.append?.h1 {
        +"Transit/JS Sample"
    }

    val location = Location.Point(SAMPLE_COORDINATES)
    GlobalScope.launch(Dispatchers.Default) {
        val result = SampleProvider.require<StationBoardService>()
            .stationBoard(
                mode = StationBoardService.Mode.DEPARTURES,
                location = location
            )
        when (result) {
            is ServiceResult.Success -> {
                document.body!!.append.div {
                    ul {
                        result.result.journeys.forEach { journey ->
                            li {
                                +"${journey.line.label} "
                                +"-> ${journey.directionTo?.name} "
                                +"@ ${(journey.stop as BaseDeparture).formatTime()}"
                            }
                        }
                    }
                }
            }
            is ServiceResult.Failure -> {
                document.body!!.append.div {
                    p {
                        +"Error: ${result.error}"
                    }
                    result.message?.let {
                        p {
                            +it
                        }
                    }
                }
            }
            is ServiceResult.NoResult -> {
                document.body!!.append.div {
                    p {
                        +"No Result!"
                    }
                }
            }
        }
    }
}