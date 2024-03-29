package de.jlnstrk.transit.api.hci.profile

import com.soywiz.klock.TimezoneOffset
import com.soywiz.klock.hours
import de.jlnstrk.transit.api.hci.BuildKonfig
import de.jlnstrk.transit.api.hci.base.HciTestProfile
import de.jlnstrk.transit.api.hci.HciAuth
import de.jlnstrk.transit.api.hci.HciClient
import de.jlnstrk.transit.api.hci.HciConfig
import de.jlnstrk.transit.api.hci.LineMatchTest
import de.jlnstrk.transit.api.hci.LocMatchTest

val BVG = HciTestProfile("BVG") {
    config = HciConfig {
        baseUrl = "https://bvg.hafas.cloud/bin/"
        client = HciClient(
            type = HciClient.Type.IPA,
            id = "BVG",
            name = "FahrInfo",
            v = "6020000"
        )
        auth = HciAuth.AccessId(aid = BuildKonfig.BVG_AID!!)
        ver = "1.44"
        ext = "BVG.1"
        timezone = TimezoneOffset(2.hours)
    }
    testData(
        LineMatchTest.DataSet(
            // Find S7, S75
            findSelfInput = "S7",
            // Find S4x only
            findOthersOnlyInput = "S4"
        ),

        LocMatchTest.DataSet.StationIdMatch(matchExtId = 900009104, findNameContains = "Wedding"),
        LocMatchTest.DataSet.StationNameMatch(matchName = "Jannowitzbrücke", findExtId = 900100004)
    )
}



