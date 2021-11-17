package de.jlnstrk.transit.api.hci.profile

import com.soywiz.klock.TimezoneOffset
import com.soywiz.klock.hours
import de.jlnstrk.transit.api.hci.BuildKonfig
import de.jlnstrk.transit.api.hci.LineMatchTest
import de.jlnstrk.transit.api.hci.LocMatchTest
import de.jlnstrk.transit.api.hci.base.HciTestProfile
import de.jlnstrk.transit.api.hci.HciAuth
import de.jlnstrk.transit.api.hci.HciClient
import de.jlnstrk.transit.api.hci.HciConfig

val SBM = HciTestProfile("SBM") {
    config = HciConfig {
        baseUrl = "https://s-bahn-muenchen.hafas.de/bin/540/"
        ver = "1.34"
        ext = "DB.R15.12.a"
        timezone = TimezoneOffset(2.hours)
        client = HciClient(
            type = HciClient.Type.IPHONE,
            id = "DB-REGIO-MVV",
            name = "MuenchenNavigator",
            v = "5010100"
        )
        auth = HciAuth.AccessId(aid = BuildKonfig.SBM_AID!!)
        salt = BuildKonfig.SBM_SALT!!
    }

    testData(
        LineMatchTest.DataSet(
            // Match S2, S20
            findSelfInput = "S 2",
            // Match S lines
            findOthersOnlyInput = "S"
        ),

        LocMatchTest.DataSet.StationIdMatch(matchExtId = 624826, findNameContains = "Lehel"),
        LocMatchTest.DataSet.StationNameMatch(matchName = "Mittersendling", findExtId = 8004154)
    )
}