package de.jlnstrk.transit.api.hci.profile

import com.soywiz.klock.hours
import de.jlnstrk.transit.api.hci.BuildKonfig
import de.jlnstrk.transit.api.hci.LineMatchTest
import de.jlnstrk.transit.api.hci.LocMatchTest
import de.jlnstrk.transit.api.hci.base.HciTestProfile
import de.jlnstrk.transit.api.hci.HciAuth
import de.jlnstrk.transit.api.hci.HciClient
import de.jlnstrk.transit.api.hci.HciConfig
import de.jlnstrk.transit.util.ZoneOffset

val RMV = HciTestProfile("RMV") {
    config = HciConfig {
        timezone = ZoneOffset(2.hours)
        baseUrl = "https://www.rmv.de/auskunft/bin/jp/"
        ver = "1.44"
        ext = "RMV.1"
        client = HciClient(
            type = HciClient.Type.WEB,
            id = "RMV",
            name = "webapp",
        )
        auth = HciAuth.AccessId(aid = BuildKonfig.RMV_AID!!)
    }

    testData(
        LineMatchTest.DataSet(
            findSelfInput = "M34",
            findOthersOnlyInput = "U"
        ),
        LocMatchTest.DataSet.StationIdMatch(
            matchExtId = 3000525,
            findNameContains = "Ostendstraße"
        ),
        LocMatchTest.DataSet.StationNameMatch(
            matchName = "Grüneburgweg",
            findExtId = 3000402
        )
    )
}