package de.jlnstrk.transit.client.hci.profile

import com.soywiz.klock.TimezoneOffset
import com.soywiz.klock.hours
import de.jlnstrk.transit.client.hci.BuildKonfig
import de.jlnstrk.transit.client.hci.base.HciTestProfile
import de.jlnstrk.transit.client.hci.HciConfig
import de.jlnstrk.transit.client.hci.LineMatchTest
import de.jlnstrk.transit.client.hci.LocMatchTest
import de.jlnstrk.transit.client.hci.model.HciAuth
import de.jlnstrk.transit.client.hci.model.HciAuthType
import de.jlnstrk.transit.client.hci.model.HciExtension
import de.jlnstrk.transit.client.hci.model.HciVersion
import de.jlnstrk.transit.client.hci.model.client.HciClient
import de.jlnstrk.transit.client.hci.model.client.HciClientId
import de.jlnstrk.transit.client.hci.model.client.HciClientType

val BVG = HciTestProfile("BVG") {
    config = HciConfig {
        baseUrl = "https://bvg-apps-ext.hafas.de/bin/"
        client = HciClient(
            type = HciClientType.IPA,
            id = HciClientId.BVG,
            name = "FahrInfo",
            v = 6020000
        )
        auth = HciAuth(
            type = HciAuthType.AID,
            aid = BuildKonfig.BVG_AID!!
        )
        ver = HciVersion._1_44
        ext = HciExtension.BVG_1
        timezone = TimezoneOffset(2.hours)
    }
    testData(
        LineMatchTest.TestData.FindSelf(
            // Find S7, S75
            findSelfInput = "S7",
        ),
        LineMatchTest.TestData.FindOthersOnly(
            // Find S4x only
            findOthersOnlyInput = "S4"
        ),

        LocMatchTest.TestData.StationIdMatch(matchExtId = "900009104", findNameContains = "Wedding"),
        LocMatchTest.TestData.StationNameMatch(matchName = "Jannowitzbrücke", findExtId = "900100004")
    )
}



