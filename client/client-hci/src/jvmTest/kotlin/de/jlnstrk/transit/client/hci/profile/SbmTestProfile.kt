package de.jlnstrk.transit.client.hci.profile

import com.soywiz.klock.TimezoneOffset
import com.soywiz.klock.hours
import de.jlnstrk.transit.client.hci.BuildKonfig
import de.jlnstrk.transit.client.hci.LineMatchTest
import de.jlnstrk.transit.client.hci.LocMatchTest
import de.jlnstrk.transit.client.hci.base.HciTestProfile
import de.jlnstrk.transit.client.hci.HciConfig
import de.jlnstrk.transit.client.hci.model.HciAuth
import de.jlnstrk.transit.client.hci.model.HciAuthType
import de.jlnstrk.transit.client.hci.model.HciExtension
import de.jlnstrk.transit.client.hci.model.HciVersion
import de.jlnstrk.transit.client.hci.model.client.HciClient
import de.jlnstrk.transit.client.hci.model.client.HciClientId
import de.jlnstrk.transit.client.hci.model.client.HciClientType

val SBM = HciTestProfile("SBM") {
    config = HciConfig {
        baseUrl = "https://s-bahn-muenchen.hafas.de/bin/540/"
        ver = HciVersion._1_34
        ext = HciExtension.DB_R_15_12_A
        timezone = TimezoneOffset(2.hours)
        client = HciClient(
            type = HciClientType.IPH,
            id = HciClientId.DB_REGIO_MVV,
            name = "MuenchenNavigator",
            v = 5010100
        )
        auth = HciAuth(
            type = HciAuthType.AID,
            aid = BuildKonfig.SBM_AID!!
        )
        salt = BuildKonfig.SBM_SALT!!
    }

    testData(
        LineMatchTest.TestData(
            // Match S2, S20
            findSelfInput = "S 2",
            // Match S lines
            findOthersOnlyInput = "S"
        ),

        LocMatchTest.TestData.StationIdMatch(matchExtId = "624826", findNameContains = "Lehel"),
        LocMatchTest.TestData.StationNameMatch(matchName = "Mittersendling", findExtId = "8004154")
    )
}