package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.client.hci.model.gis.HciGisManoeuvre
import de.jlnstrk.transit.client.hci.model.gis.HciGisOrientation
import de.jlnstrk.transit.client.hci.model.gis.HciGisRoute
import de.jlnstrk.transit.common.model.GisRoute
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext
import kotlin.time.Duration.Companion.ZERO
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

internal fun HciGisRoute.asCommon(context: HciCommonContext): GisRoute {
    return GisRoute(
        distance = dist!!,
        duration = durR ?: durS ?: ZERO,
        segments = segL.map {
            GisRoute.Segment(
                summary = it.name,
                description = it.manTx,
                maneuver = when (it.man) {
                    HciGisManoeuvre.CH -> GisRoute.Maneuver.CHANGE_HIGHWAY
                    HciGisManoeuvre.CIF -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.COF -> GisRoute.Maneuver.CHECK_OUT_FERRY
                    HciGisManoeuvre.EF -> GisRoute.Maneuver.ENTER_FERRY
                    HciGisManoeuvre.EL -> GisRoute.Maneuver.ELEVATOR
                    HciGisManoeuvre.ELD -> GisRoute.Maneuver.ELEVATOR_DOWN
                    HciGisManoeuvre.ELU -> GisRoute.Maneuver.ELEVATOR_UP
                    HciGisManoeuvre.EN -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.ER -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.ES -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.ESD -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.ESU -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.FOC -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.FOL -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.FOR -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.FR -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.HL -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.HR -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.KHL -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.KHR -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.KL -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.KR -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.KSL -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.KSR -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.LE -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.LF -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.LR -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.LV -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.NO -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.ON -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.RI -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.RL -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.RR -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.SIR -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.SL -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.SR -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.ST -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.STA -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.STD -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.STU -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.TLL -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.TLR -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.TO -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.TRL -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.TRR -> GisRoute.Maneuver.CHECK_IN_FERRY
                    HciGisManoeuvre.UT -> GisRoute.Maneuver.CHECK_IN_FERRY
                },
                orientation = when (it.ori) {
                    HciGisOrientation.E -> GisRoute.Orientation.EAST
                    HciGisOrientation.N -> GisRoute.Orientation.NORTH
                    HciGisOrientation.NE -> GisRoute.Orientation.NORTH_EAST
                    HciGisOrientation.NW -> GisRoute.Orientation.NORTH_WEST
                    HciGisOrientation.S -> GisRoute.Orientation.SOUTH
                    HciGisOrientation.SE -> GisRoute.Orientation.SOUTH_EAST
                    HciGisOrientation.SW -> GisRoute.Orientation.SOUTH_WEST
                    HciGisOrientation.U -> null
                    HciGisOrientation.W -> GisRoute.Orientation.WEST
                }
            )
        }
    )
}